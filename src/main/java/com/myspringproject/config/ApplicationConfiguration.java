package com.myspringproject.config;

import com.myspringproject.database.repository.CrudRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.myspringproject",
useDefaultFilters = false,
includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,value = Component.class),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,value = CrudRepository.class),
        @ComponentScan.Filter(type = FilterType.REGEX,pattern = "com\\..+Repository")
}
)
public class ApplicationConfiguration {
}
