package org.example.softwarearchitecture.repository;

import org.example.softwarearchitecture.dox.Address;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address,String>{
    @Query("select * from address1 a where a.user_id=:uid")
    List<Address> findAddresses(String uid);
}
