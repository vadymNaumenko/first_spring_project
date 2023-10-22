package com.spring.project.database.pool;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component("pool1")
@RequiredArgsConstructor
public class ConnectionPool {

    @Value("${db.username}")
    private final String userName;
    @Value("${db.pool.size}")
    private final Integer poolSize;



    @PostConstruct
    private void init() {
        System.out.println("Init connection pool");
    }

//    public void afterPropertiesSet() {
//        System.out.println("Properties set");
//    }

    @PreDestroy
    private void destroy() {
        System.out.println("Clear connection pool");
    }

}
