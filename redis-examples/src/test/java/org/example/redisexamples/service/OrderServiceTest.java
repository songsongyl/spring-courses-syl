package org.example.redisexamples.service;

import lombok.extern.slf4j.Slf4j;
import org.example.redisexamples.dto.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class OrderServiceTest {

    @Autowired
    private OrderService orderService;
    @Test
    void addItems() {
        log.debug("addItems");
        List<Item> items = List.of(
                Item.builder().id("01HN7JNHG93N3RSPF60MEG4WE2").total(30).build(),
                Item.builder().id("01HN7JNHG93N3RSPF60MEG4WE3").total(30).build()
        );
        orderService.addItems(items);
        log.debug("added");
    }

    @Test
    void buy() throws InterruptedException {
        var count = 200;
        var random = new Random();
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < 200; i++) {
            Thread.startVirtualThread(()->{
                long buy = orderService.buy("01HN7JNHG93N3RSPF60MEG4WE2", String.valueOf(random.nextInt(count)));
                log.debug("{}",buy);
                latch.countDown();
            });
        }

        latch.await();
        Thread.sleep(60000);
    }
}