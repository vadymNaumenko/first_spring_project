package com.spring.project.integration.database.repository;

import com.spring.project.database.entity.Role;
import com.spring.project.database.entity.User;
import com.spring.project.database.repository.UserRepository;
import com.spring.project.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
class UserRepositoryTest {

    private final UserRepository userRepository;

    @Test
    void checkUpdate() {
       User ivan =  userRepository.getById(1L);
       assertSame(Role.ADMIN,ivan.getRole());

       int count = userRepository.updateRole(Role.USER, 1L, 2L);
            assertEquals(2, count);

        User theSameIvan =  userRepository.getById(1L);
        assertSame(Role.USER,theSameIvan.getRole());
    }

    @Test
    void checkQueries() {

        List<User> users = userRepository.findAllBy("a", "ov");
        assertEquals(3, users.size());
        System.out.println("sd");
    }


}