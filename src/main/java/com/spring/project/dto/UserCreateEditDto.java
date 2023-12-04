package com.spring.project.dto;

import com.spring.project.database.entity.Role;
import jakarta.persistence.*;
import lombok.Value;

import java.time.LocalDate;

@Value
public class UserCreateEditDto {

    String username;
    LocalDate birthDate;
    String lastname;
    String firstname;
    Role role;
    Integer companyId;

}
