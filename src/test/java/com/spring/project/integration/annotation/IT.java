package com.spring.project.integration.annotation;

import com.spring.project.integration.TestApplicationRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ActiveProfiles("test")
@Transactional
@SpringBootTest(classes = TestApplicationRunner.class)
@WithMockUser(username = "test@gmail.com", password = "test", authorities = {"ADMIN","USER"})
public @interface IT {
}
