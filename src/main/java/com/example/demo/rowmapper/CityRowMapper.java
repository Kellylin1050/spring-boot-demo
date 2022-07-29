package com.example.demo.rowmapper;

import com.example.demo.model.City;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        City city = new City();
        city.setCityId(resultSet.getInt("city_id"));
        city.setCityName(resultSet.getString("city_name"));

        return city;
    }
}
