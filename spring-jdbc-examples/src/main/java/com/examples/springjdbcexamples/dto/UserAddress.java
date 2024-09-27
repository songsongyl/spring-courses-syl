package com.examples.springjdbcexamples.dto;

import com.examples.springjdbcexamples.dox.Address;
import com.examples.springjdbcexamples.dox.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAddress {
    private User user;
    private List<Address>  addresses;
}
