package net.friend.aspect;

import lombok.extern.slf4j.Slf4j;
import net.friend.service.MySum;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MyAop {
    @Before(value = "execution(* net.friend.service.*.*(..))")
    public void beforeReturning(JoinPoint joinPoint) {
        String param1 = (String) joinPoint.getArgs()[0];
        String param2 = (String) joinPoint.getArgs()[1];

        try{
            double i1 = Double.parseDouble(param1);
            double i2 = Double.parseDouble(param2);
        } catch (NumberFormatException e){
            log.info("Sum: N/A");
        }
    }
//    @AfterThrowing(pointcut = "execution(* net.friend.service.*.*(..))", throwing = "error")
//    public void afterThrowing(JoinPoint joinPoint, Throwable error){
//        System.out.println("");
//    }


}
