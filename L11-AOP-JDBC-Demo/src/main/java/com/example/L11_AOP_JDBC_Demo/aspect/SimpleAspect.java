package com.example.L11_AOP_JDBC_Demo.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {


    private Logger LOGGER = LoggerFactory.getLogger(SimpleAspect.class);

    @Before("execution(* com.example.L11_AOP_JDBC_Demo.service.ProductService.getById(..))")
    public void beforeMethod(){
        LOGGER.info("Executing before actual method");
    }

//    @Before("@annotation(com.example.L11_AOP_JDBC_Demo.aspect.LogExecutionTime)")
//    public void beforeAnnotation(){
//        LOGGER.info("Executing before actual annotated method");
//    }
//
//
//    @After("@annotation(com.example.L11_AOP_JDBC_Demo.aspect.LogExecutionTime)")
//    public void afterAnnotation(){
//        LOGGER.info("Executing after actual annotated method");
//    }


    @Around("@annotation(com.example.L11_AOP_JDBC_Demo.aspect.LogExecutionTime)")
    public Object aroundAnnotatedMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // start time
        long start = System.currentTimeMillis();
        // call actual method
        Object result = proceedingJoinPoint.proceed();
        // end time
        long end = System.currentTimeMillis();
        LOGGER.info("Executing {} time: {} ", proceedingJoinPoint.getTarget(), end-start);
        return result;
    }
}
