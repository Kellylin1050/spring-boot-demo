package L5.SelectCSD.controller;

import L5.SelectCSD.Student;
import L5.SelectCSD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public String insert(@RequestBody Student student){
        String sql = "INSERT INTO student(name) VALUE(:studentName)";

        Map<String,Object> map =new HashMap<>();
        //map.put("studentId" ,student.getId());
        map.put("studentName" , student.getName());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map),keyHolder);

        int id = keyHolder.getKey().intValue();
        System.out.println("mysql 自動生成的 id 為: " + id);

        return "執行 INSERT sql";
    }

    @PostMapping("/students/batch")
    public String insertList(@RequestBody List<Student> studentList){
        String sql = "INSERT INTO student(name) VALUE (:studentName)";

        MapSqlParameterSource[] parameterSources = new MapSqlParameterSource[studentList.size()];

        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);

            parameterSources[i] = new MapSqlParameterSource();
            parameterSources[i].addValue("studentName" , student.getName());
        }

        namedParameterJdbcTemplate.batchUpdate(sql,parameterSources);

        return "執行一批 INSERT sql";
    }




    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId){
        String sql = "DELETE FROM student WHERE id = :studentId";

        Map<String,Object> map = new HashMap<>();
        map.put("studentId" , studentId);

        namedParameterJdbcTemplate.update(sql,map);

        return "執行 DELETE sql";
    }

    @GetMapping("/students/{studentId}")
    public Student select(@PathVariable Integer studentId){
       return studentService.getById(studentId); //三層架構
        //一般寫法
       /* String sql = "SELECT id, name FROM student WHERE id = :studentId";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId",studentId);

        List<Student> list = namedParameterJdbcTemplate.query(sql ,map ,new StudentRowMapper());

        //return list.get(0); //取得list中第一個object
        if (list.size() > 0){
            return list.get(0);
        }else {
            return null;
        }*/
    }
}
