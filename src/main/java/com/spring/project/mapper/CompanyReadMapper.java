package com.spring.project.mapper;

import com.spring.project.database.entity.Company;
import com.spring.project.dto.CompanyReadDto;
import org.springframework.stereotype.Component;

@Component
public class CompanyReadMapper implements Mapper<Company, CompanyReadDto>{

    @Override
    public CompanyReadDto map(Company company) {
        return new CompanyReadDto(company.getId(),
                company.getName());
    }
}
