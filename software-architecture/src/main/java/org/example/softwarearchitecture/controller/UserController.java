package org.example.softwarearchitecture.controller;

import lombok.RequiredArgsConstructor;
import org.example.softwarearchitecture.dox.Address;
import org.example.softwarearchitecture.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user/")
public class UserController {

    private final UserService userService;

    @GetMapping("addresses")
    public Map<String, Object> getUser(@RequestAttribute String uid) {
        List<Address> addresses = userService.listAddresses(uid);
        return Map.of("addresses", addresses);
    }
}
