package com.spring.project.database.repository;

import com.spring.project.bpp.Auditing;
import com.spring.project.bpp.Transaction;
import com.spring.project.database.entity.Company;
import com.spring.project.database.pool.ConnectionPool;
import jakarta.annotation.PostConstruct;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Transaction
@Auditing
@RequiredArgsConstructor
@Repository
public class CompanyRepository implements CrudRepository<Integer, Company> {

    private final ConnectionPool pool1;
    private final List<ConnectionPool> pools;
    @Value("${db.pool.size}")
    private final Integer poolSize;




    @PostConstruct
    private void init() {
        System.out.println("init company repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("Find by id method");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("delete method");

    }
}
