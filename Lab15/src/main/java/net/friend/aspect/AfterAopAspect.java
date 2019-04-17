package net.friend.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AfterAopAspect {

  @AfterReturning(value = "execution(* net.friend.service.*.*(..))",
      returning = "result")
  public void afterReturning(JoinPoint joinPoint, Object result) {
    log.info("{} returned with value {}", joinPoint, result);
  }

  @After(value = "execution(* net.friend.service..*.*(..))")
  public void after(JoinPoint joinPoint) {
    log.info("after execution of {}", joinPoint);
  }
}
