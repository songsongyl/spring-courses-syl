package com.examples.springjdbcexamples.dto;

import com.examples.springjdbcexamples.dox.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAddress2 {
    private String id;
    private String name;
    private List<Address> addresses;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
