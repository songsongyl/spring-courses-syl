package org.example.softwarearchitecture.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.softwarearchitecture.dox.Address;
import org.example.softwarearchitecture.dox.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void addAdminTest() {
        User u = User.builder()
                .account("admin")
                .password("1001")
                .role(User.ADMIN)
                .build();
        log.info(u.toString());
        userRepository.save(u);
    }

    @Test
    public void addUserTest() {
        User u = User.builder()
                .account("1001")
                .password("1001")
                .role(User.USER)
                .build();
        log.info(u.toString());
        userRepository.save(u);
    }

    @Test
    public void findUserByIdTest() {
        userRepository.findById("1283947928306098176").ifPresent(System.out::println);
    }

    @Test
    public void findUserTest() {
        User u = userRepository.find("admin", "1001");
        log.debug("{}", u);
    }

    @Test
    public void addAddressTest() {
        Address a = Address.builder()
                .detail("491")
                .userId("1283947928306098176")
                .build();
        addressRepository.save(a);
        Address a2 = Address.builder()
                .detail("237")
                .userId("1283947928306098176")
                .build();
        addressRepository.save(a2);
    }

    @Test
    public void findAddressesTest() {
        addressRepository.findAddresses("1283947928306098176").forEach(System.out::println);
    }

    @Test
    public void findUserByAddressTest() {
        User u = userRepository.find("1283947928306098176");
        log.debug("{}", u);
    }
}
