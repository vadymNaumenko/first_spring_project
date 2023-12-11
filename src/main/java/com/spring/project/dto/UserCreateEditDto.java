package com.spring.project.dto;

import com.spring.project.database.entity.Role;
import com.spring.project.validation.UserInfo;
import com.spring.project.validation.group.CreateAction;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Value
@FieldNameConstants
@UserInfo(groups = CreateAction.class)
public class UserCreateEditDto {

    @Email
    String username;
    LocalDate birthDate;

    @Size(min = 3, max = 64)
    String lastname;

    String firstname;
    Role role;
    Integer companyId;

    MultipartFile image;

}
