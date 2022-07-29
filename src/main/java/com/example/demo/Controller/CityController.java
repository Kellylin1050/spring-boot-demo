package com.example.demo.Controller;

//import Test.City;
//import Test.Dao.CityRepository;
import com.example.demo.model.City;
import com.example.demo.dao.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @PostMapping("/city")
    public String insert(@RequestBody City cityName){

        cityRepository.save(cityName);

        return "執行資料庫的 Create 操作";
    }

    @PutMapping("city/{cityId}")//可以放在Request body或url傳遞
    public String update(@PathVariable Integer cityId,
                         @RequestBody City city) {

        City c = cityRepository.findById(cityId).orElse(null);//查詢是否存在

        if (c != null) {
            c.setCityName(city.getCityName());
            cityRepository.save(c);

            return "執行資料庫的 Update 操作";
        }else {
            return "Update 失敗，數據不存在";
        }

    }
    @DeleteMapping("city/{cityId}")//只能將參數放在url傳遞
    public String delete(@PathVariable Integer cityId){

        cityRepository.deleteById(cityId);

        return "執行資料庫的 Delete 操作";
    }



    @GetMapping("city/{cityId}")//只能將參數放在url傳遞
    public City read(@PathVariable Integer cityId){

        City city = cityRepository.findById(cityId).orElse(null);

        return city;
    }
}
