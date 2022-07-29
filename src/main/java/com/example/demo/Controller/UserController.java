package com.example.demo.Controller;

//import Test.User;
//import Test.Dao.UserRepository;

import com.example.demo.model.User;
import com.example.demo.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public String insert(@RequestBody User userName){

        userRepository.save(userName);

        return "執行資料庫的 Create 操作";
    }

    @PutMapping("users/{userId}")//可以放在Request body或url傳遞
    public String update(@PathVariable Integer userId,
                         @RequestBody User user) {

        User u = userRepository.findById(userId).orElse(null);//查詢是否存在

        if (u != null) {
            u.setUserName(user.getUserName());
            userRepository.save(u);

            return "執行資料庫的 Update 操作";
        }else {
            return "Update 失敗，數據不存在";
        }

    }
    @DeleteMapping("users/{userId}")//只能將參數放在url傳遞
    public String delete(@PathVariable Integer userId){

        userRepository.deleteById(userId);

        return "執行資料庫的 Delete 操作";
    }

    @GetMapping("users/{userId}")//只能將參數放在url傳遞
    public User read(@PathVariable Integer userId){

        User user = userRepository.findById(userId).orElse(null);

        return user;
    }

}
