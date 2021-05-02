package com.ucalp.sempar.repository;

import com.ucalp.sempar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User> {

    public Optional<User> findByUsername(final String username);

}
