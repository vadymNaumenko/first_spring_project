package com.spring.project.dto;

import com.spring.project.database.entity.Role;
import lombok.Value;

import java.time.LocalDate;

@Value
public class UserReadDto {
    Long id;
    String username;
    LocalDate birthDate;
    String lastname;
    String firstname;
    String image;
    Role role;
    CompanyReadDto company;

}
