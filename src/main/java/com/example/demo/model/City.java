package com.example.demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cityId")
    private Integer cityId;

    @Column(name = "CityName")
    private String cityName;


    //@OneToOne(cascade = CascadeType.ALL)
    //private User user;

    //@ManyToOne
    //@JoinColumn(name="userId",nullable=false)
    //private User user;

    @ManyToMany(mappedBy="cities")
    private Set<User> users = new HashSet<User>(0);

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
