package com.spring.project.integration.database.repository;

import com.spring.project.database.entity.Role;
import com.spring.project.database.entity.User;
import com.spring.project.database.repository.UserRepository;
import com.spring.project.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
class UserRepositoryTest {

    private final UserRepository userRepository;

    @Test
    void checkPageable(){
        PageRequest pageable = PageRequest.of(1, 2, Sort.by("id"));
        List<User> result = userRepository.findAllBy(pageable);
        assertEquals(2,result.size());
    }

    @Test
    void checkSort(){
        Sort.TypedSort<User> sort = Sort.sort(User.class);
        sort.by(User::getFirstname)
                .and(sort.by(User::getLastname));

        List<User> allUsersTop3 = userRepository.findTop3ByBirthDateBefore(LocalDate.now(),sort);
        assertEquals(3,allUsersTop3.size());

    }

    @Test
    void checkFirstTop(){
        Sort sort = Sort.by("firstname").and(Sort.by("lastname"));
        List<User> allUsersTop3 = userRepository.findTop3ByBirthDateBefore(LocalDate.now(),sort);
        assertEquals(3,allUsersTop3.size());

        Optional<User> topUser = userRepository.findTopByOrderByIdDesc();
        assertTrue(topUser.isPresent());
        topUser.ifPresent(user -> assertEquals(5L,user.getId()));
    }
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