package com.myspringproject.database.pool;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class ConnectionPool implements InitializingBean {
    private String userName;
    private Integer poolSize;
    private List<Object> args;
    private Map<String, Object> properties;

    public ConnectionPool() {
    }

    public ConnectionPool(String userName,
                          Integer poolSize,
                          List<Object> args,
                          Map<String, Object> properties) {
        this.userName = userName;
        this.poolSize = poolSize;
        this.args = args;
        this.properties = properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
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

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Properties set");
    }
}
