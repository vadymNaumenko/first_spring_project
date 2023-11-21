package com.spring.project.database.repository;

import com.spring.project.database.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository  extends JpaRepository<Company,Integer> {

    boolean existsById(Integer id);
    List<Company> findAllByNameContainingIgnoreCase(String fragment);
}
