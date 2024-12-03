package org.example.softwarearchitecture.service;

import lombok.extern.slf4j.Slf4j;
import org.example.softwarearchitecture.dox.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void addUser() {
        userService.addUser(User.builder().account("syl").password("syl").role(User.ADMIN).build());
    }
}
