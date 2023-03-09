package com.day3.exercice1DiJava;

import com.day3.exercice1DiJava.interfaces.MessageProvider;

public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    } }
