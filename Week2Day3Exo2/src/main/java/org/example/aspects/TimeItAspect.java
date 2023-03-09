package org.example.aspects;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
@Aspect
@Component
public class TimeItAspect {
    @Pointcut("@annotation(TimeIt)")
    public void timeIt() {}

    @After("execution(* org.example.tests.Test.timeIt(..))")
    public void logExecutionTime() {
        System.out.println("Method est execute");
    }
}
