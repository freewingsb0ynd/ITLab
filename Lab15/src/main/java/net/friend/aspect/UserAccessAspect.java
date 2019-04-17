package net.friend.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class UserAccessAspect {

  //What kind of method calls I would intercept
  //execution(* PACKAGE.*.*(..))
  //Weaving & Weaver
  @Before("execution(* net.friend.repository.*.*(..))")
  public void before(JoinPoint joinPoint){
    //Advice
    log.info(" Check for user access ");
    log.info(" Allowed execution for {}", joinPoint);
  }
}
