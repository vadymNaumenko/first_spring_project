package com.spring.project.database.repository;

import com.spring.project.database.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository  extends JpaRepository<Company,Integer> {

    boolean existsById(Integer id);
    @Query("select c from Company c " +
            "join fetch c.locales cl" +
            " where c.name = :name")
    Optional<Company> findByName(String name);
    List<Company> findAllByNameContainingIgnoreCase(String fragment);
}
