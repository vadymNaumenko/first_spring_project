package com.spring.project.database.repository;

import com.spring.project.database.entity.Company;
import org.springframework.data.repository.Repository;

import java.util.Optional;


public interface CompanyRepository  extends Repository<Company,Integer> {
    public Optional<Company> findById(Integer id);
    public void delete(Company entity);
}
