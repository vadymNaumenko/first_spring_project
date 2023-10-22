package com.spring.project.config;

import com.spring.project.config.condition.JpaCondition;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
@Conditional(JpaCondition.class)
@Configuration
public class JpaConfiguration {

    @PostConstruct
    public void init(){
        System.out.println("Jpa configuration enabled");
    }
}
