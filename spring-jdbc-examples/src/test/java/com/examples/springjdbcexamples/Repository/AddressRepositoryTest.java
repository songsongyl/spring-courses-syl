package com.examples.springjdbcexamples.Repository;

import com.examples.springjdbcexamples.dox.Address;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
public class AddressRepositoryTest {
    @Autowired
    private AddressRepository addressRepository;
    @Test
   void findByUserId() {
        for (Address address : addressRepository.findByUId("1283947928306098176")) {
            log.debug("address: {}", address);
        }
    }

    @Test
    void find(){
        for (Address address : addressRepository.findByUserId("1283947928306098176")) {
            log.debug("address: {}", address);
        }
    }


    @Test
    void deleteById(){
        addressRepository.deleteById("1");
    }

    @Test
    void updateAddress() {
        Address address =  Address.builder().id("1").detail("222").build();
        addressRepository.updateDetail(address.getDetail(),address.getId());
    }
}
