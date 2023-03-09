package com.day3.exercice1DiAnnotation;

import com.day3.exercice1DiAnnotation.interfaces.MessageProvider;

public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    } }
