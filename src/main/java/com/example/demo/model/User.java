package com.example.demo.model;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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

    @ManyToMany(targetEntity = City.class)
    @JoinTable(name = "user_city",

            joinColumns = {@JoinColumn(name = "sys_user_id",referencedColumnName = "userId")},
            //@JoinColumn(name = "sys_user_name",referencedColumnName = "userName")
            inverseJoinColumns = {@JoinColumn(name = "sys_city_id",referencedColumnName = "cityId")})
            //@JoinColumn(name = "sys_city_name",referencedColumnName = "cityName")
    private Set<City> cities = new HashSet<>();

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

    public Set<City> getCities() {
        return cities;
    }
    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

}