package com.spring.project.config;

import com.spring.project.database.repository.CrudRepository;
import com.spring.web.config.WebConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
@Import(WebConfiguration.class)
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.spring.project",
useDefaultFilters = false,
includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,value = Component.class),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,value = CrudRepository.class),
        @ComponentScan.Filter(type = FilterType.REGEX,pattern = "com\\..+Repository")
}
)
public class ApplicationConfiguration {
}
