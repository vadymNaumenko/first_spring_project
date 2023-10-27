package com.spring.project.integration.service;

import com.spring.project.ApplicationRunner;
import com.spring.project.database.entity.Company;
import com.spring.project.dto.CompanyReadDto;
import com.spring.project.listener.entity.EntityEvent;
import com.spring.project.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = ApplicationRunner.class,initializers = ConfigDataApplicationContextInitializer.class)
@SpringBootTest
public class CompanyServiceIT {
    private static final Integer COMPANY_ID = 1;

    @Autowired
    private CompanyService companyService;
    @Test
    void findById(){

        var actualResult = companyService.findById(COMPANY_ID);

        assertTrue(actualResult.isPresent());

        var expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));

    }
}
