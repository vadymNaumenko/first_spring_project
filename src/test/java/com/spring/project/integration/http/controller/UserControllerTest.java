package com.spring.project.integration.http.controller;

import com.spring.project.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static com.spring.project.dto.UserCreateEditDto.Fields.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@IT
@RequiredArgsConstructor
@Sql({
        "classpath:sql/data.sql"
})
@AutoConfigureMockMvc
@WithMockUser(username = "test@gmail.com", password = "test", authorities = {"ADMIN","USER"})
class UserControllerTest {

    private final MockMvc mockMvc;

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("user/users"))
                .andExpect(model().attributeExists("users"))
                .andExpect(model().attribute("users", hasSize(5)));
    }
    @Test
    @WithMockUser(username = "test@gmail.com", password = "test", authorities = {"ADMIN"})
    void create() throws Exception {

        mockMvc.perform(post("/users")
                .param(username,"test@gmail.com")
                .param(firstname,"test")
                .param(lastname,"testTEST")
                .param(role,"ADMIN")
                .param(companyId,"1")
                .param(birthDate,"2000-01-01")
        ).andExpectAll(
                status().is3xxRedirection(),
                redirectedUrlPattern("/users/{\\d+}")
        );
    }

}