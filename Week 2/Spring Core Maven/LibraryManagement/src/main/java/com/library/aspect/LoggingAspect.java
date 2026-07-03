package com.library.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.library.service.BookService.display(..))")
    public void beforeDisplay() {
        System.out.println("Before method execution");
    }

    @After("execution(* com.library.service.BookService.display(..))")
    public void afterDisplay() {
        System.out.println("After method execution");
    }
}