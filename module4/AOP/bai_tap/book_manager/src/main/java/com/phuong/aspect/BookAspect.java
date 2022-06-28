package com.phuong.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BookAspect {

    @AfterReturning(pointcut = " execution(public * com.phuong.controller.BookController.*(..)) ")
    public void logHistory(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println("The " + name + " method just worked");
    }
}
