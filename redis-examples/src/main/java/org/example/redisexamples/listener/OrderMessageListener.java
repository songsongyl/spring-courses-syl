package org.example.redisexamples.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.redisexamples.dto.Order;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderMessageListener implements StreamListener<String, ObjectRecord<String, String>> {

    private final RedisTemplate<String, String> redisTemplate;
    @Override
    public void onMessage(ObjectRecord<String, String> message) {
       log.debug("{}", message.getValue());
        log.debug("{}", message.getId());
        redisTemplate.opsForStream().acknowledge(Order.GROUP_NAME,message);
        // 移除已消费消息。为测试没有移除
        // template.opsForStream().delete(Order.STREAM_KEY, message.getId());
    }
}
