package com.spring.project;

import com.spring.project.config.ApplicationConfiguration;
import com.spring.project.database.pool.ConnectionPool;
import com.spring.project.service.CompanyService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class MySpringProjectApplication {

    public static void main(String[] args) {
//        SpringApplication.run(MySpringProjectApplication.class, args);

        String value = "hello";
//        System.out.println(CharSequence.class.isAssignableFrom(value.getClass()));
//        System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(value.getClass()));
//        System.out.println(Serializable.class.isAssignableFrom(value.getClass()));

        try (var context = new AnnotationConfigApplicationContext()) {
            //      clazz -> String -> Map<String, Object>
            context.register(ApplicationConfiguration.class);
            context.getEnvironment().setActiveProfiles("web","prod");
            context.refresh();

            var connectionPool = context.getBean("pool1", ConnectionPool.class);

            System.out.println(connectionPool);

            var companyService = context.getBean( CompanyService.class);
            System.out.println(companyService.findById(1));

        }
    }
}
