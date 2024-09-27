package com.examples.springjdbcexamples.Repository;

import com.examples.springjdbcexamples.dox.Address;
import com.examples.springjdbcexamples.dto.AddressUser;
import com.examples.springjdbcexamples.dto.AddressUser2;
import com.examples.springjdbcexamples.mapper.AddressUser2RowMapper;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {

    //基于uid查询address
    @Query("""
            select * from address a where a.user_id = :id;
            """)
    List<Address> findByUId(String id);

    //利用封装的方法
    List<Address> findByUserId(String id);

    //基于id删除
    @Modifying
    @Query("""
            delete from address where id = :aid;
            """)
    void deleteById(String aid);

    //更新信息基于id
    @Query("""
                  update address a set a.detail = :detail where a.id = :id
            """)
    @Modifying
    void updateDetail(String detail, String id);

    //利用aId查询addressUser
    @Query("""
        select a.id as id, a.detail as detail, a.user_id as user_id,a.create_time as create_time,a.update_time as update_time,u.name as name
        from address a join user u on a.user_id = u.id
        where a.id = :aid;
""")
    AddressUser findAddressUserById( String aid);

    //利用aid查询addressUser2
    @Query(value = """
select * from address a ,user u  where u.id = a.user_id and  a.id = :aid;
""",rowMapperClass = AddressUser2RowMapper.class)
    AddressUser2 findAddressUser2ById( String aid);


}
