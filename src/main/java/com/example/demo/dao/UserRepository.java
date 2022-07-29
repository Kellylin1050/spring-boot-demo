package com.example.demo.dao;

//import Test.User;
import com.example.demo.model.User;
import org.springframework.data.repository.CrudRepository;



public interface UserRepository extends CrudRepository<User,Integer> {

}
