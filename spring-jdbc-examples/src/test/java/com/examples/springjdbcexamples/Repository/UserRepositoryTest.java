package com.examples.springjdbcexamples.Repository;

import com.examples.springjdbcexamples.dox.Address;
import com.examples.springjdbcexamples.dox.User;
import com.examples.springjdbcexamples.dto.UserAddress;
import com.examples.springjdbcexamples.dto.UserAddress2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Slf4j
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void save() {
        var user = User.builder().name("syl").build();
        userRepository.save(user);
    }
    @Test
    void findAddressByUserId(){
        for (Address address : userRepository.findAddressesById("1283947928306098176")) {
            log.debug(address.toString());
        }
    }

    @Test
    void findById(){
        userRepository.findById("1283947928306098176").ifPresent(user -> log.debug("{}",user));
    }

    @Test
    void findAll(){
        int page = 4;
        int pageSize = 5;
        userRepository.findAll((page-1)*pageSize,5).forEach(System.out::println);
    }

    @Test
    void findAllByPageable(){
        int page = 4;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page-1,pageSize);
        userRepository.findAll(pageable).forEach(System.out::println);
    }

    @Test
    void update(){
        String name = "syl1";
        userRepository.updateById(name,"1283947928306098176");
    }

    @Test
    void delete(){
        userRepository.deleteById("1283947928306098176");
    }

    @Test
    void findDesc(){
        int page = 1;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page-1,pageSize);
        userRepository.findByIdDesc(pageable).forEach(System.out::println);
    }

    @Test
    void findAddressByUserId2(){
        for (Address address : userRepository.findAddressesByUserId("1283947928306098176")) {
            log.debug(address.toString());
        }
    }

    @Test
    void findUserAddressByUserId(){
        UserAddress userAddress = userRepository.findUserAddressByUserId("1283947928306098176");
        log.debug("{}",userAddress.getUser());
        userAddress.getAddresses().forEach(a->log.debug(a.toString()));
    }

    @Test
    void findUserAddress2ByUserId(){
        UserAddress2 u = userRepository.findUserAddress2ByUserId("1283947928306098176");
        log.debug(u.toString());
    }

    @Test
    void findUserCount(){
        userRepository.findUserCountDto().forEach(System.out::println);
    }

}