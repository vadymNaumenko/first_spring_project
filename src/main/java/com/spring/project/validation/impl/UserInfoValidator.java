package com.spring.project.validation.impl;

import com.spring.project.database.repository.CompanyRepository;
import com.spring.project.dto.UserCreateEditDto;
import com.spring.project.validation.UserInfo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static org.springframework.util.StringUtils.hasText;

@Component
@RequiredArgsConstructor
public class UserInfoValidator implements ConstraintValidator<UserInfo, UserCreateEditDto> {

    private final CompanyRepository companyRepository;
    @Override
    public boolean isValid(UserCreateEditDto value, ConstraintValidatorContext context) {
        return hasText(value.getFirstname()) || hasText(value.getLastname());
    }
}
