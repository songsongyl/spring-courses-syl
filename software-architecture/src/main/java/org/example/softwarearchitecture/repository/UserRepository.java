package org.example.softwarearchitecture.repository;

import org.example.softwarearchitecture.dox.User;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,String> {

    @Query("select * from user1 u join address1 a on u.id = a.user_id where a.id = :aid")
    User find(String aid);
    @Query("select * from user1 u where u.account=:account and u.password=:password")
    User find(String account, String password);

}
