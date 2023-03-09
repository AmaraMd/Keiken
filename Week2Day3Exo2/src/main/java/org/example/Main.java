package org.example;

import org.example.tests.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TimeltConfig.class);
        Test sampleClass = context.getBean(Test.class);
        sampleClass.timeIt();
    }
}