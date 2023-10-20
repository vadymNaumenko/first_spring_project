package com.myspringproject.service;

import com.myspringproject.database.repository.CompanyRepository;
import com.myspringproject.database.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository ;
    private final CompanyRepository companyRepository;

    public UserService(UserRepository userRepository, CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }


}
