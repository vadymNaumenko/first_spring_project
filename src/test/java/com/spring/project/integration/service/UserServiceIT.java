package com.spring.project.integration.service;

import com.spring.project.database.pool.ConnectionPool;
import com.spring.project.integration.annotation.IT;
import com.spring.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.annotation.DirtiesContext;

@IT
@RequiredArgsConstructor
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserServiceIT {


    private final UserService userService;


    private final ConnectionPool pool1;
@Test
    void test(){
    System.out.println();
}
@Test
    void test2(){
    System.out.println();
}
}
