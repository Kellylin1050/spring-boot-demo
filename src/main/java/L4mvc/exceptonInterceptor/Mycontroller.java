package L4mvc.exceptonInterceptor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller {

    //攔截器
    @RequestMapping("/test1")
    public String test1(){
        System.out.println("執行 test1 方法");
        return "Hello test1";
    }
/*
    @RequestMapping("/test2")
    public String test2(){
        System.out.println("執行 test2 方法");
        return "Hello test2";
    }*/


    //@ControllerAdvice+@ExceptionHandler 統一管理Exception
    /*@RequestMapping("/test1")
    public String test1(){
        throw new RuntimeException("test1 error");
    }

    @RequestMapping("/test2")
    public String test2(){
        throw new IllegalArgumentException("test2 error");
    }


    //ResponseEntity定義回傳類型
    @RequestMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Hello World");

    }*/
}
