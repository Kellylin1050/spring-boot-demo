package com.example.demo.dao;

//import Test.City;
import com.example.demo.model.City;
import org.springframework.data.repository.CrudRepository;


public interface CityRepository extends CrudRepository<City,Integer> {

}
