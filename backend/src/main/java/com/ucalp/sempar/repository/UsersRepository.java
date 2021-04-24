package com.ucalp.sempar.repository;

import com.ucalp.sempar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UsersRepository extends JpaRepository<User, String> {

}
