package com.examples.springjdbcexamples.Repository;

import com.examples.springjdbcexamples.dox.Address;
import com.examples.springjdbcexamples.dox.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,String> {
    @Query("""
            select a.* from user u, address a
            where u.id=a.user_id and u.id=:uid
            """)
    List<Address> findAddressesById(String uid);
    @Query("""
            select * from user u limit :offset,:pageSize
            """)
    List<User> findAll(long offset,long pageSize);

    @Query("""
            select * from user u
            limit :#{#pageable.offset}, :#{#pageable.pageSize}
            """)
    List<User> findAll(Pageable pageable);

    @Query("""
            select * from user u order by u.id desc limit :#{#pageable.offset}, :#{#pageable.pageSize}
          """)
    List<User> findByIdDesc(Pageable pageable);

    @Query("""
            select a.id as id, a.create_time as create_time, a.update_time as update_time, name, detail, a.user_id as user_id
            from user u join address a
            on u.id = a.user_id
            where u.id=:userId
            """)
    List<Address> findAddressesByUserId(String userId);
}
