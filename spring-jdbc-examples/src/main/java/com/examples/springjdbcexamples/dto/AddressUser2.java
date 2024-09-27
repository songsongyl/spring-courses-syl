package com.examples.springjdbcexamples.dto;


import com.examples.springjdbcexamples.dox.Address;
import com.examples.springjdbcexamples.dox.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressUser2 {
    private User user;
    private Address address;
}
