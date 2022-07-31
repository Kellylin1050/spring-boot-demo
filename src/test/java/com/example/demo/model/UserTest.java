package com.example.demo.model;

import com.example.demo.dao.CityRepository;
import com.example.demo.dao.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class UserTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CityRepository cityRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void addUserAndCity(){
        User user1 = new User();
        //User user2 = new User();
        //User user3 = new User();
        City city1 = new City();
        //City city2 = new City();
        //City city3 = new City();
        user1.setUserId(6);
        user1.setUserName("Jay");
        //user2.setUserId(7);
        //user2.setUserName("Candy");
        //user3.setUserId(8);
        //user3.setUserName("Eva");
        city1.setCityId(6);
        city1.setCityName("Taiwan");
        //city2.setCityId(7);
        //city2.setCityName("America");
        //city3.setCityId(8);
        //city3.setCityName("France");

        city1.getUsers().add(user1);
        //city2.getUsers().add(user2);
        //city3.getUsers().add(user3);

        user1.getCities().add(city1);
        //user2.getCities().add(city2);
        //user3.getCities().add(city3);
        userRepository.save(user1);
        //userRepository.save(user2);
        //userRepository.save(user3);
        cityRepository.save(city1);
        //cityRepository.save(city2);
        //cityRepository.save(city3);
    }


}