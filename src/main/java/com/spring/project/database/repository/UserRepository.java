package com.spring.project.database.repository;
import com.spring.project.database.entity.Role;
import com.spring.project.database.entity.User;
import com.spring.project.dto.PersonalInfo;
import com.spring.project.dto.PersonalInfo2;
import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("select u from User u " +
            "where u.firstname like %:firstname% and u.lastname like %:lastname%")
    List<User> findAllBy(String firstname,String lastname);

//  List<User> findAllByFirstnameContainingAndLastnameContaining(String firstname,String lastname);

    @Query(value = "SELECT * FROM users WHERE username = :username",
            nativeQuery = true)
    List<User> findAllByUsername(String username);

    @Modifying(clearAutomatically = true)
    @Query("update User u " +
            "set u.role = :role " +
            "where u.id in (:ids)")
    int updateRole(Role role, Long... ids);

    Optional<User> findTopByOrderByIdDesc();

    List<User> findTop3ByBirthDateBeforeOrderByBirthDateDesc(LocalDate birthDate);

    @QueryHints(@QueryHint(name = "org.hibernate.fetchSize", value ="50" ))
    @Lock(LockModeType.PESSIMISTIC_READ)
    List<User> findTop3ByBirthDateBefore(LocalDate birthDate, Sort sort);

    //    List<User> findAllBy(Pageable pageable);

    //Collection, Stream
    //Streamable, Slice, Page
//    @EntityGraph("User.company")
    @EntityGraph(attributePaths = {"company","company.locales"})
    @Query(value = "select u from User u",
    countQuery = "select count(distinct u.firstname) from User u") //переопределения встрояного count(id)
    Page<User> findAllBy(Pageable pageable);

//    List<PersonalInfo> findAllByCompanyId(Integer id);
//    <T> List<T> findAllByCompanyId(Integer id, Class<T> clazz);
    @Query(value = "SELECT firstname," +
            "lastname," +
            "birth_date birthDate" +
            " FROM users" +
            " WHERE company_id = :id",nativeQuery = true)
    List<PersonalInfo2> findAllByCompanyId(Integer id);





}
