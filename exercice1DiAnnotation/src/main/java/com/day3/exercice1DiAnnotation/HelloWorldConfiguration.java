package com.day3.exercice1DiAnnotation;

import com.day3.exercice1DiAnnotation.interfaces.MessageProvider;
import com.day3.exercice1DiAnnotation.interfaces.MessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {
    @Bean
    public MessageProvider provider() {
        return (MessageProvider) new HelloWorldMessageProvider();
    }
    // equivalent to  <bean id="renderer" class=".."/>
    @Bean
    public MessageRenderer renderer(){
        MessageRenderer renderer = (MessageRenderer) new StandardOutMessageRenderer();
        renderer.setMessageProvider(provider());
        return renderer;
    }

}
