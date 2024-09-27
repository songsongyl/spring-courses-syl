package com.examples.springjdbcexamples.mapper;

import com.examples.springjdbcexamples.dox.Address;
import com.examples.springjdbcexamples.dox.User;
import com.examples.springjdbcexamples.dto.UserAddress;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserAddressResultSetExtractor implements ResultSetExtractor<UserAddress> {

    @Override
    public UserAddress extractData(ResultSet rs) throws SQLException, DataAccessException {
        User user = null;
        List<Address> addressList = new ArrayList<Address>();
        while (rs.next()) {
            if(user == null){
                user = User.builder()
                        .id(rs.getString("u.id"))
                        .name(rs.getString("name"))
                        .createTime(rs.getObject("create_time", LocalDateTime.class))
                        .updateTime(rs.getObject("update_time", LocalDateTime.class))
                        .build();
            }
            Address address = Address.builder()
                    .id(rs.getString("a.id"))
                    .detail(rs.getString("detail"))
                    .userId(rs.getString("user_id"))
                    .createTime(rs.getObject("create_time", LocalDateTime.class))
                    .updateTime(rs.getObject("update_time", LocalDateTime.class))
                    .build();
            addressList.add(address);
        }
        return UserAddress
                .builder()
                .user(user)
                .addresses(addressList)
                .build();
    }
}
