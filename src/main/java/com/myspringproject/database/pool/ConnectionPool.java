package com.myspringproject.database.pool;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component("pool1")
public class ConnectionPool {
    private final String userName;
    private final Integer poolSize;



    @Autowired
    public ConnectionPool(@Value("${db.username}") String userName,
                          @Value("${db.pool.size}") Integer poolSize) {
        this.userName = userName;
        this.poolSize = poolSize;

    }


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
