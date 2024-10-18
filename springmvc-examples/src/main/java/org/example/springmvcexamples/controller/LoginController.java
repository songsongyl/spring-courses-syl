package org.example.springmvcexamples.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springmvcexamples.service.UserService;
import org.example.springmvcexamples.dox.User;
import org.example.springmvcexamples.exception.Code;
import org.example.springmvcexamples.vo.ResultVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class LoginController {

    private final UserService userService;
    @PostMapping("login")
    public ResultVo login(@RequestBody User user) {
        User userR = userService.getUserByAccount(user.getAccount(), user.getPassword());
        if(userR == null) {
            return ResultVo.error(Code.LOGIN_ERROR);
        }
        return ResultVo.success(userR);
    }
}
