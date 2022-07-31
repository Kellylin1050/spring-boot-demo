package com.example.demo.dao;

//import Test.User;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;



public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

}
