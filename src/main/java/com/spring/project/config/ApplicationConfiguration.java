package com.spring.project.config;

import com.spring.project.database.pool.ConnectionPool;
import com.spring.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;


@Import(WebConfiguration.class)
@Configuration

public class ApplicationConfiguration {
    @Bean("pool2")
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public ConnectionPool pool2(@Value("${db.username}") String username) {
        return new ConnectionPool(username, 20);
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public ConnectionPool pool3( ) {
        return new ConnectionPool("test-pool", 25);
    }

}
