package org.example.redisexamples.component;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ULIDTest {

    @Autowired
    private ULID ulid;
    @Test
    void nextULID() {
//        01JCAXPNZRMMSMSJ8MT5XPM2KG
        log.info(ulid.nextULID());
        //01JCAXPNZR5KPYQHXGWXTWJ1JY
        log.info(ulid.nextULID());
        log.info(ulid.nextULID());

    }
}