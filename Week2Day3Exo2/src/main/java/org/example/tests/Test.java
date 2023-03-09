package org.example.tests;

import org.example.TimeIt;
import org.springframework.stereotype.Service;

@Service
public class Test {
    @TimeIt
    public void timeIt() throws InterruptedException {
        System.out.println("test");
    }
}
