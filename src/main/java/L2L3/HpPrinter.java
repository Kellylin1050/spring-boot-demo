package L2L3;

import org.springframework.stereotype.Component;

@Component
public class HpPrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println("Hp印表機: " + message);
    }



    /*@Value("${printer.name}")
    private String name;

    @Value("${printer.count:20}")
    private int count ;

    @PostConstruct
    public void init(){
        count = 5;
    }

    @Override
    public void print(String message) {
        count--;
        System.out.println(name + ": " + message);
        //System.out.println("HP印表機: " + message);
        System.out.println("剩餘使用次數: " + count);
    }*/

}
