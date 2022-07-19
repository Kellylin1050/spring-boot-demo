package L4mvc.api;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class StudentController {

    //API
    @PostMapping("/students")//第一種寫法限制只能用post //可以放在Request body或url傳遞
    //@RequestMapping(value = "/students" , method = RequestMethod.POST) 第二種寫法
    public String create(@RequestBody @Valid Student3 student){

        return "執行資料庫的 Create 操作";
    }

    @GetMapping("students/{studentsId}")//只能將參數放在url傳遞
    public String read(@PathVariable Integer studentsId){
        return "執行資料庫的 Read 操作";
    }

    @PutMapping("students/{studentsId}")//可以放在Request body或url傳遞
    public String update(@PathVariable Integer studentsId,
                         @RequestBody Student3 student){
        return "執行資料庫的 Update 操作";
    }

    @DeleteMapping("students/{studentsId}")//只能將參數放在url傳遞
    public String delete(@PathVariable Integer studentsId){
        return "執行資料庫的 Delete 操作";
    }

}
