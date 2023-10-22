package com.spring.project.database.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface CrudRepository <K,E>{
    Optional<E> findById(K id);
    void delete (E entity);
}
