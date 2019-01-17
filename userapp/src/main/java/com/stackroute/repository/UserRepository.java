package com.stackroute.repository;

import com.stackroute.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByUserName(String name);
    public User findByPassword(String password);
    //CRUD operation are done without using any line of code here.

}
