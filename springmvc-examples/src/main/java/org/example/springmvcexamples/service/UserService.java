package org.example.springmvcexamples.service;

import org.example.springmvcexamples.dox.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static final List<User> USERS = create();
    private static List<User> create() {
        User u = User.builder().id("1").name("syl").account("100").password("123456").build();
        return List.of(u);
    }

    public List<User> listUsers() {
        return USERS;
    }

    public User getUserByAccount(String account,String password) {
        return  USERS.stream()
                .filter(user -> user.getAccount().equals(account) && user.getPassword().equals(password))
                .findFirst().orElse(null);
    }

    public User getUserByAccount(String account) {
        return  USERS.stream()
                .filter(user -> user.getAccount().equals(account))
                .findFirst().orElse(null);
    }
}
