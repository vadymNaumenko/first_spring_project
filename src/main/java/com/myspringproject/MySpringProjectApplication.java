package com.myspringproject;

import com.myspringproject.database.pool.ConnectionPool;
import com.myspringproject.database.repository.CompanyRepository;
import com.myspringproject.database.repository.UserRepository;
import com.myspringproject.ioc.Container;
import com.myspringproject.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class MySpringProjectApplication {

    public static void main(String[] args) {
//        SpringApplication.run(MySpringProjectApplication.class, args);

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        ConnectionPool connectionPool = context.getBean("p1", ConnectionPool.class);
        System.out.println(connectionPool);

        CompanyRepository companyRepository = context.getBean("companyRepository", CompanyRepository.class);

        System.out.println(companyRepository);

    }

}
