package com.myspringproject;

import com.myspringproject.database.pool.ConnectionPool;
import com.myspringproject.database.repository.CompanyRepository;
import com.myspringproject.database.repository.CrudRepository;
import com.myspringproject.database.repository.UserRepository;
import com.myspringproject.ioc.Container;
import com.myspringproject.service.UserService;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Serializable;

@SpringBootApplication
public class MySpringProjectApplication {

    public static void main(String[] args) {
//        SpringApplication.run(MySpringProjectApplication.class, args);

        String value = "hello";
        System.out.println(CharSequence.class.isAssignableFrom(value.getClass()));
        System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(value.getClass()));
        System.out.println(Serializable.class.isAssignableFrom(value.getClass()));

        try (var context = new ClassPathXmlApplicationContext("application.xml")) {
            //      clazz -> String -> Map<String, Object>
            var connectionPool = context.getBean("p1", ConnectionPool.class);
            System.out.println(connectionPool);

            var companyRepository = context.getBean("companyRepository", CrudRepository.class);
            System.out.println(companyRepository.findById(1));

        }
    }
}
