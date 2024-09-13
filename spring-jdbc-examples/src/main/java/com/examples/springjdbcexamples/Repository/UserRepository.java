package com.examples.springjdbcexamples.Repository;

import com.examples.springjdbcexamples.dox.Address;
import com.examples.springjdbcexamples.dox.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,String> {
//   基于uid利用多表查询地址
    @Query("""
            select a.* from user u, address a
            where u.id=a.user_id and u.id=:uid
            """)
    List<Address> findAddressesById(String uid);

//    查询用户 限制个数
    @Query("""
            select * from user u limit :offset,:pageSize
            """)
    List<User> findAll(long offset,long pageSize);

    //    查询用户 限制个数 封装
    @Query("""
            select * from user u
            limit :#{#pageable.offset}, :#{#pageable.pageSize}
            """)
    List<User> findAll(Pageable pageable);

    //基于id更新name
    @Query("""
            update user u set name = :name where id = :uid
          """)
    @Modifying
    void updateById(String name,String uid);
//    查询用户并降序排序
    @Query("""
            select * from user u order by u.id desc limit :#{#pageable.offset}, :#{#pageable.pageSize}
          """)
    List<User> findByIdDesc(Pageable pageable);


    //利用join查询address
    @Query("""
            select a.id as id, a.create_time as create_time, a.update_time as update_time, name, detail, a.user_id as user_id
            from user u join address a
            on u.id = a.user_id
            where u.id=:userId
            """)
    List<Address> findAddressesByUserId(String userId);
}
