package com.myspringproject.database.pool;

import java.util.List;
import java.util.Map;

public class ConnectionPool {
     private final String userName;
     private final Integer poolSize;
     private  final List<Object> args;
     private  final Map<String,Object> properties;

    public ConnectionPool(String userName,
                          Integer poolSize,
                          List<Object> args,
                          Map<String, Object> properties) {
        this.userName = userName;
        this.poolSize = poolSize;
        this.args = args;
        this.properties = properties;
    }


}
