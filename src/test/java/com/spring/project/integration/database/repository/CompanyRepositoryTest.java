package com.spring.project.integration.database.repository;

import com.spring.project.database.entity.Company;
import com.spring.project.integration.annotation.IT;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
class CompanyRepositoryTest {

    private final EntityManager entityManager;
    @Test
    void findById() {
        var company = entityManager.find(Company.class, 1);

        assertNotNull(company);

    }
    @Test
    void sava(){
        var company = Company.builder().
                name("Apple")
                .locales(Map.of(
                        "ru","Apple title",
                        "en", "apple description"
                ))
                .build();
        entityManager.persist(company);
        assertNotNull(company.getId());
    }

}