package com.spring.project.database.repository;

import com.spring.project.database.entity.User;
import com.spring.project.dto.UserFilter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
public class FilterUserRepositoryImpl implements FilterUserRepository{

    private final EntityManager entityManager;
    @Override
    public List<User> findAllByFilter(UserFilter filter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteria= cb.createQuery(User.class);

        Root<User> user = criteria.from(User.class);
        criteria.select(user);

        List<Predicate> predicates = new ArrayList<>();
        if (filter.firstname() != null){
            predicates.add(cb.like(user.get("firstname"),filter.firstname()));
        }
        if (filter.lastname() != null){
            predicates.add(cb.like(user.get("lastname"),filter.lastname()));
        }
        if (filter.birthDate() != null){
            predicates.add(cb.lessThan(user.get("birthDate"),filter.birthDate()));
        }

        criteria.where(predicates.toArray(Predicate[]::new));

        return entityManager.createQuery(criteria).getResultList();
    }
}
