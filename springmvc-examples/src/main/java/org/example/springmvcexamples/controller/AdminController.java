package org.example.springmvcexamples.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springmvcexamples.dox.User;
import org.example.springmvcexamples.exception.Code;
import org.example.springmvcexamples.service.UserService;
import org.example.springmvcexamples.vo.ResultVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/")
public class AdminController {

    private final UserService userService;
    @GetMapping("users")
    public ResultVo getUsers(){
        return ResultVo.success(userService.listUsers());
    }

    @GetMapping("users/{account}")
    public ResultVo getUser(@PathVariable String account){
//       User user =  userService.getUserByAccount(account);
//       if(user == null){
//           return ResultVo.error(Code.BAD_REQUEST);
//       }
//       return ResultVo.success(user);
        return ResultVo.success(userService.getUserByAccount(account));
//        感觉设计有点不合理
    }
}
