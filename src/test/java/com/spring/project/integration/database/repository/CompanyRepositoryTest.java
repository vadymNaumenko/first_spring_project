package com.spring.project.integration.database.repository;

import com.spring.project.database.entity.Company;
import com.spring.project.database.repository.CompanyRepository;
import com.spring.project.integration.annotation.IT;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
class CompanyRepositoryTest {

    private static final Integer APPLE_ID = 4;
    private final EntityManager entityManager;
    private final TransactionTemplate transactionTemplate;
    private final CompanyRepository companyRepository;

    @Test
    void checkFindByQueries(){
        assertAll(()->{
            assertTrue(companyRepository.existsById(1));
            companyRepository.findAllByNameContainingIgnoreCase("a");
        });
    }

    @Test
    void delete(){
      Optional <Company> maybeCompany = companyRepository.findById(APPLE_ID);

      assertTrue(maybeCompany.isPresent());
      maybeCompany.ifPresent(companyRepository::delete);
      entityManager.flush();
      assertTrue(companyRepository.findById(APPLE_ID).isEmpty());

    }
    @Test
    void findById() {
        transactionTemplate.executeWithoutResult(tx ->{

            var company = entityManager.find(Company.class, 1);

            assertNotNull(company);

        });

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