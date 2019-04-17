package net.friend.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MethodExecutionCalculationAspect {

  @Around("@annotation(net.friend.TrackTime)")
  public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
    long startTime = System.currentTimeMillis();

    Object value = joinPoint.proceed();

    long timeTaken = System.currentTimeMillis() - startTime;
    log.info("Time Taken by {} is {}", joinPoint, timeTaken);

    return value;
  }
}