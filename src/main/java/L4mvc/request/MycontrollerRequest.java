package L4mvc.request;

import org.springframework.web.bind.annotation.*;

@RestController
public class MycontrollerRequest {


    //取得請求參數
    @RequestMapping("/test1")
    public String test1(@RequestParam Integer id,
                        @RequestParam(defaultValue = "Amy") String name){
        System.out.println("id: " + id);
        System.out.println("name: " + name);
        return "Hello test1";
    }

    @RequestMapping("/test2")
    public String test2(@RequestBody Student2 student){
        System.out.println("student id: " + student.getId());
        System.out.println("student name: " +student.getName());
        return "Hello test2";
    }

    @RequestMapping("/test3")
    public String test3(@RequestHeader String info){
        System.out.println("header info: " + info);
        return "Hello test3";
    }

    @RequestMapping("/test4/{id}/{name}")
    public String test4(@PathVariable Integer id,
                        @PathVariable String name){
        System.out.println("Path id: " + id);
        System.out.println("Path name: " + name);
        return "Hello test4";
    }




    /*@RequestMapping("/product")
    public Store product(){
        Store store = new Store();
        List<String> list = new ArrayList<>();
        list.add("蘋果");
        list.add("橘子");
        store.setProductlist(list);
        return store;
    }
    //student2
    @RequestMapping("/user")
    public Student user(){
        Student student = new Student();
        student.setName("Judy");
        return student;
    }*/



}
