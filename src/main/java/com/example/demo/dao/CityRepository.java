package com.example.demo.dao;

//import Test.City;
import com.example.demo.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends JpaRepository<City,Integer>, JpaSpecificationExecutor<City> {

}
