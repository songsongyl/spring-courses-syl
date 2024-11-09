package org.example.redisexamples.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.concurrent.TimeUnit;


@SpringBootTest
@Slf4j
class ExpireServiceTest {
    @Autowired
    private ExpireService expireService;

    @Test
    void expire() throws InterruptedException {
        for (int i = 0; i < 11; i++) {
            boolean expire = expireService.expire("api:522", 5, 2);
            log.debug("expire:{}", expire);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}