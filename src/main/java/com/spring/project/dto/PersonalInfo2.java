package com.spring.project.dto;

import org.springframework.beans.factory.annotation.Value;

public interface PersonalInfo2 {
    String getFirstname();
    String getLastname();
    String getBirthDate();
   @Value("#{target.firstname + ' ' + target.lastname}")
    String getFullName();
}
