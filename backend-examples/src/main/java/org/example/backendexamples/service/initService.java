package org.example.backendexamples.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.backendexamples.dox.User;
import org.example.backendexamples.repository.UserRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class initService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @Transactional
    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        String account = "admin";
        log.debug("111");
        long count = userRepository.count();
        if(count > 0){
            return;
        }
        log.debug("222");
        User user = User.builder()
                .account(account)
                .name(account)
                .role(User.ADMIN)
                .password(passwordEncoder.encode(account))
                .build();
        log.debug("333");
        userRepository.save(user);
//        userService.addUser(user);
        log.debug("444");
    }
}
