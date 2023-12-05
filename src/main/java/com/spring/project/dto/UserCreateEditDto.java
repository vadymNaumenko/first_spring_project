package com.spring.project.dto;

import com.spring.project.database.entity.Role;
import jakarta.persistence.*;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

@Value
@FieldNameConstants
public class UserCreateEditDto {

    String username;
    LocalDate birthDate;
    String lastname;
    String firstname;
    Role role;
    Integer companyId;

}
