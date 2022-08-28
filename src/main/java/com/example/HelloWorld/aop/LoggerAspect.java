package com.example.HelloWorld.aop;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    @Pointcut("execution(* com.example.HelloWorld.controllers.HelloWorldController.helloWorld*(..))")
    public void methodsForLogging() {

    }

    @Before("methodsForLogging()")
    public void beforeHelloWorld() {
        log.info("before hello world");
    }

    @After("methodsForLogging()")
    public void afterHelloWorld() {
        log.info("after hello world");
    }

    @Around("methodsForLogging()")
    public void aroundHelloWorld(ProceedingJoinPoint jp) {
        log.info("1 around hello world " + jp.getSignature().getName());
        try {
            jp.proceed();
        } catch (Throwable ignore) {}
        log.info("2 around hello world " + jp.getSignature().getName());
    }

    @AfterReturning("methodsForLogging()")
    public void afterRetuningHelloWorld() {
        log.info("afterReturning hello world");
    }

    @AfterThrowing("methodsForLogging()")
    public void afterThrowingHelloWorld() {
        log.info("afterThrowing hello world");
    }
}
