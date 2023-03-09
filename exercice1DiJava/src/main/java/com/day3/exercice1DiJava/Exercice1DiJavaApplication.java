package com.day3.exercice1DiJava;

import com.day3.exercice1DiJava.interfaces.MessageProvider;
import com.day3.exercice1DiJava.interfaces.MessageRenderer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercice1DiJavaApplication {

	public static void main(String[] args) {
		//SpringApplication.run(Exercice1DiJavaApplication.class, args);
		MessageRenderer mr = new StandardOutMessageRenderer();
		MessageProvider mp = new HelloWorldMessageProvider();
		mr.setMessageProvider(mp);
		mr.render();
	}

}
