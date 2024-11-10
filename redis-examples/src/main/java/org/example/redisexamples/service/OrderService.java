package org.example.redisexamples.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.redisexamples.component.ULID;
import org.example.redisexamples.dto.Item;
import org.example.redisexamples.dto.Order;
import org.redisson.api.*;
import org.redisson.api.stream.StreamAddArgs;
import org.redisson.client.codec.IntegerCodec;
import org.redisson.client.codec.StringCodec;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final RedissonClient redissonClient;
    private final ULID ulid;

    public void addItems(List<Item> itemList){
        RBatch batch = redissonClient.createBatch();
        log.debug("2222");
        for(Item item : itemList){
            RMapAsync<String, Integer> map = batch.getMap(Item.PRE_KEY + item.getId(), IntegerCodec.INSTANCE);
            map.putAsync("total", item.getTotal());
        }
        log.debug("11111");
        batch.execute();
    }

    public  long buy(String itemId,String userId){
      long q = redissonClient.getFunction()
                .call(FunctionMode.WRITE,
                        "buy_70",
                        FunctionResult.LONG,
                        List.of(Item.PRE_KEY + itemId));
      if(q == -1){
          log.debug("抢光了");
          return -1;
      }
      log.debug("抢购成功");
      var id = ulid.nextULID();
      Order order = Order.builder()
              .id(id)
              .userId(userId)
              .itemId(itemId)
              .build();
      redissonClient.getBucket(Order.PRE_KEY + id).set(order);
      sendMessage(order);
      return q;
    }

    public void sendMessage(Order order){
        redissonClient.getStream(Order.STREAM_KEY,StringCodec.INSTANCE)
                .add(StreamAddArgs.entry("orderid",order.getId()));
    }
}
