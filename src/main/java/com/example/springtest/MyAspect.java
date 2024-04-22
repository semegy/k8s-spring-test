package com.example.springtest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @Pointcut("@annotation(AspectCut)")
    public void point() {

    }

    @Around("point()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("aaa");
        Object proceed = joinPoint.proceed();
        System.out.println("bbb");
        return proceed;
    }

}
