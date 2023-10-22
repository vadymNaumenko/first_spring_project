package com.spring.project.service;

import com.spring.project.database.entity.Company;
import com.spring.project.database.repository.CrudRepository;
import com.spring.project.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;




}
