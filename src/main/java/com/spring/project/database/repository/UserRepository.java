package com.spring.project.database.repository;
import com.spring.project.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("select u from User u " +
            "where u.firstname like %:firstname% and u.lastname like %:lastname%")
    List<User> findAllBy(String firstname,String lastname);
//    List<User> findAllByFirstnameContainingAndLastnameContaining(String firstname,String lastname);

    @Query(value = "SELECT * FROM users WHERE username = :username",
            nativeQuery = true)
    List<User> findAllByUsername(String username);

}
