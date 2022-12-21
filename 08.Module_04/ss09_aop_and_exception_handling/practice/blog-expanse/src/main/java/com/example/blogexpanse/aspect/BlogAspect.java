package com.example.blogexpanse.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;


@Aspect
@Component
public class BlogAspect {
    //demo
//    private Logger logger = Logger.getLogger(BlogAspect.class.getName());
//
//    @Pointcut("execution(* com.example.blogexpanse.service.impl.BlogServiceImpl.*())")
//    public void blogService(){
//    }
//
//    @Before("blogService()")
//    public void getLog(JoinPoint joinPoint) throws Throwable{
//        String methodName = joinPoint.getSignature().getName();
//        logger.info("Before: Call " + methodName);
//    }


    //James
    @Before(value = "executeController()")
    public void beforeExecuteController(){
        System.out.println("before controller");
    }

    @After(value = "executeController()")
    public void afterExecuteController(){
        System.out.println("after controller");
    }

    @Pointcut(value = "within(com.example.blogexpanse.controller.*)")
    public void executeController(){
    }
}
