package com.spring.project.database.repository;

import com.spring.project.database.entity.Role;
import com.spring.project.database.entity.User;
import com.spring.project.dto.PersonalInfo;
import com.spring.project.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {

    List<User> findAllByFilter (UserFilter userFilter);
    List<PersonalInfo> findAllByCompanyIdAndRole(Integer company, Role role);
}
