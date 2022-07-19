package com.example.demo;

import L4mvc.api.Student3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/students")
    public String insert(@RequestBody Student student){

        studentRepository.save(student);

        return "執行資料庫的 Create 操作";
    }

    @PutMapping("students/{studentId}")//可以放在Request body或url傳遞
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student student) {

        Student s = studentRepository.findById(studentId).orElse(null);//查詢是否存在

        if (s != null) {
            s.setName(student.getName());
            studentRepository.save(s);

            return "執行資料庫的 Update 操作";
        }else {
            return "Update 失敗，數據不存在";
        }

        //student.setId(studentId);
        //studentRepository.save(student);
    }
    @DeleteMapping("students/{studentId}")//只能將參數放在url傳遞
    public String delete(@PathVariable Integer studentId){

        studentRepository.deleteById(studentId);

        return "執行資料庫的 Delete 操作";
    }

    @GetMapping("students/{studentId}")//只能將參數放在url傳遞
    public Student read(@PathVariable Integer studentId){

        Student student = studentRepository.findById(studentId).orElse(null);

        return student;
    }
}
