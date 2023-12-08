package com.spring.project.dto;

import com.spring.project.database.entity.Role;
//import com.spring.project.validation.UserINfo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

@Value
@FieldNameConstants
//@UserINfo
public class UserCreateEditDto {

    @Email
    String username;
    LocalDate birthDate;

    @NotNull
    @Size(min = 3, max = 64)
    String lastname;

    @NotNull
    String firstname;
    Role role;
    Integer companyId;

}
