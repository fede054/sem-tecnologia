package com.ucalp.sempar.repository;

import com.ucalp.sempar.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface LogRepository extends JpaRepository<Log, Long> {

}
