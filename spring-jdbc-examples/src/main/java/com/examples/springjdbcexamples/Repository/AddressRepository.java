package com.examples.springjdbcexamples.Repository;

import com.examples.springjdbcexamples.dox.Address;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address,String> {
    @Query("""
            select * from address a where a.user_id = :id;
            """)
    List<Address> findByUId(String id);

    List<Address> findByUserId(String id);

    @Query("""
            update address a set a.detail = :detail where a.id = :id
          """)
    @Modifying
    void updateDetail(String detail,String id);
}
