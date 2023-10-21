package com.myspringproject.service;

import com.myspringproject.database.entity.Company;
import com.myspringproject.database.repository.CompanyRepository;
import com.myspringproject.database.repository.CrudRepository;
import com.myspringproject.database.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;

    public UserService(UserRepository userRepository,
                       CrudRepository<Integer, Company> companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }


}
