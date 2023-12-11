package com.spring.project.mapper;

import com.spring.project.database.entity.User;
import com.spring.project.dto.CompanyReadDto;
import com.spring.project.dto.UserReadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserReadMapper implements Mapper<User, UserReadDto> {

    private final CompanyReadMapper companyReadMapper;

    @Override
    public UserReadDto map(User user) {

        CompanyReadDto companyReadDto = Optional.ofNullable(user.getCompany())
                .map(companyReadMapper::map)
                .orElse(null);

        return new UserReadDto(
                user.getId(),
                user.getUsername(),
                user.getBirthDate(),
                user.getLastname(),
                user.getFirstname(),
                user.getImage(),
                user.getRole(),
                companyReadDto
        );
    }

}
