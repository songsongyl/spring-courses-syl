package org.example.backendexamples.controller;

import lombok.RequiredArgsConstructor;
import org.example.backendexamples.dox.User;
import org.example.backendexamples.service.UserService;
import org.example.backendexamples.vo.ResultVo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    @PostMapping("users")
    public ResultVo postUser(@RequestBody User user){
        userService.addUser(user);
        return ResultVo.ok();
    }
    @PutMapping("users/{account}/password")
    public ResultVo putPassword(@PathVariable String account){
        userService.updateUserPassword(account);
        return ResultVo.ok();
    }
    @GetMapping("users")
    public ResultVo getUsers(){
        return ResultVo.success(userService.listUser());
    }
}
