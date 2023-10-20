package com.myspringproject;

import com.myspringproject.database.pool.ConnectionPool;
import com.myspringproject.database.repository.CompanyRepository;
import com.myspringproject.database.repository.UserRepository;
import com.myspringproject.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringProjectApplication.class, args);
        ConnectionPool connectionPool = new ConnectionPool();
        UserRepository userRepository = new UserRepository(connectionPool);
        CompanyRepository companyRepository = new CompanyRepository(connectionPool);
        UserService userService = new UserService(userRepository,companyRepository);

    }

}
