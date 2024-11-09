package org.example.backendexamples.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.backendexamples.dox.User;
import org.example.backendexamples.exception.Code;
import org.example.backendexamples.exception.XException;
import org.example.backendexamples.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User getUser(String account){
        return userRepository.findByAccount(account);
    }
    @Transactional
    public void updateUserPassword(String account){
        User user = userRepository.findByAccount(account);
        if(user == null){
           throw  XException.builder().number(Code.ERROR).message("用户不存在").build();
        }
        user.setPassword(passwordEncoder.encode(account));
        //将密码重置回账号
        userRepository.save(user);
    }

    @Transactional
    public void updateUserPassword(String uid,String password){
        User user = userRepository.findById(uid).orElse(null);
        if(user == null){
            throw  XException.builder().number(Code.ERROR).message("用户不存在").build();
        }
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }
    @Transactional
    public void addUser(User user){
        //管理员添加用户默认密码为账号
        user.setPassword(passwordEncoder.encode(user.getAccount()));
        userRepository.save(user);
    }

    public List<User> listUser(){
        return userRepository.findAll();
    }
}
