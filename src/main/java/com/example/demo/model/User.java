package com.example.demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    Integer userId;

    @Column(name = "userName")
    String userName;



    //@OneToOne(mappedBy="user")
    //@JoinColumn(name = "cityId")
    //private City city;

    //@OneToMany(mappedBy="user", cascade={CascadeType.ALL})
    //private List<City> city;




    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}