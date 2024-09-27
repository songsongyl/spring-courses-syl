package com.examples.springjdbcexamples.mapper;

import com.examples.springjdbcexamples.dox.Address;
import com.examples.springjdbcexamples.dto.UserAddress;
import com.examples.springjdbcexamples.dto.UserAddress2;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserAddress2ResultSetExtractor implements ResultSetExtractor<UserAddress2> {

    @Override
    public UserAddress2 extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<Address> addressList = new ArrayList<Address>();
        UserAddress2.UserAddress2Builder builder = UserAddress2.builder();
        while (rs.next()) {
            builder.id(rs.getString("u.id"));
            builder.name(rs.getString("u.name"));
            builder.createTime(rs.getObject("u.create_time", LocalDateTime.class));
            builder.updateTime(rs.getObject("u.update_time", LocalDateTime.class));
            Address address = Address.builder()
                    .id(rs.getString("a.id"))
                    .detail(rs.getString("detail"))
                    .userId(rs.getString("user_id"))
                    .createTime(rs.getObject("a.create_time", LocalDateTime.class))
                    .updateTime(rs.getObject("a.update_time", LocalDateTime.class))
                    .build();
            addressList.add(address);
        }
        return builder.addresses(addressList).build();
    }
}
