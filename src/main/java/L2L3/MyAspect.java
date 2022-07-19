package L2L3;

/*@Aspect
@Component
public class MyAspect {

    @Around("execution(* com.example.demo.HpPrinter.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        //System.out.println("I'm around before");
        Date start = new Date();

        //執行切入點的方法
        Object obj = pjp.proceed();

        Date end = new Date();
        long time = end.getTime()-start.getTime();
        System.out.println("總共執行了:" + time + " ms");
        return obj;

    }

    @Before("execution(* com.example.demo.HpPrinter.*(..))")
    public void before() {
        System.out.println("I'm before");
    }
    @After("execution(* com.example.demo.HpPrinter.*(..))")
    public void after() {
        System.out.println("I'm after");
    }
}*/
