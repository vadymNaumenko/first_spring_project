package com.spring.project.integration.service;

import com.spring.project.database.entity.Role;
import com.spring.project.database.pool.ConnectionPool;
import com.spring.project.dto.UserCreateEditDto;
import com.spring.project.dto.UserReadDto;
import com.spring.project.integration.annotation.IT;
import com.spring.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@IT
@Sql({
        "classpath:sql/data.sql"
})
@RequiredArgsConstructor
public class UserServiceIT {


    private final UserService userService;
    private static final Long USER_ID = 1L;
    private static final Integer COMPANY_ID = 1;

    @Test
    void findAll() {
        List<UserReadDto> result = userService.findAll();
        System.out.println();
        assertEquals(5, result.size());
    }

    @Test
    void findById() {
        Optional<UserReadDto> result = userService.findById(USER_ID);
        System.out.println();
        assertTrue(result.isPresent());
        assertEquals("ivan@gmail.com",result.get().getUsername());
    }

    @Test
    void create(){
        UserCreateEditDto userDto = new UserCreateEditDto(
                "test@gmail.com",
                LocalDate.now(),
                "Test",
                "Test",
                Role.ADMIN,
                COMPANY_ID
        );
        UserReadDto actual = userService.create(userDto);
        assertEquals(userDto.getUsername(),actual.getUsername());
        assertEquals(userDto.getBirthDate(),actual.getBirthDate());
        assertEquals(userDto.getFirstname(),actual.getFirstname());
        assertEquals(userDto.getLastname(),actual.getLastname());
        assertEquals(userDto.getCompanyId(),actual.getCompany().id());
        assertEquals(userDto.getRole(),actual.getRole());
    }

    @Test
    void update(){
        UserCreateEditDto userDto = new UserCreateEditDto(
                "test@gmail.com",
                LocalDate.now(),
                "Test",
                "Test",
                Role.ADMIN,
                COMPANY_ID
        );
        Optional<UserReadDto> actual = userService.update(USER_ID, userDto);
        
        assertTrue(actual.isPresent());
        actual.ifPresent(user->{
            assertEquals(userDto.getUsername(),user.getUsername());
            assertEquals(userDto.getBirthDate(),user.getBirthDate());
            assertEquals(userDto.getFirstname(),user.getFirstname());
            assertEquals(userDto.getLastname(),user.getLastname());
            assertEquals(userDto.getCompanyId(),user.getCompany().id());
            assertEquals(userDto.getRole(),user.getRole());
        });
        
    }
    
    @Test
    void delete(){
        assertTrue(userService.delete(USER_ID));
        assertFalse(userService.delete(-199L));
    }

}
