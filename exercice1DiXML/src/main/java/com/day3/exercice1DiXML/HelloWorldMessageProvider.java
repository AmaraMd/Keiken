package com.day3.exercice1DiXML;

import com.day3.exercice1DiXML.interfaces.MessageProvider;

public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    } }
