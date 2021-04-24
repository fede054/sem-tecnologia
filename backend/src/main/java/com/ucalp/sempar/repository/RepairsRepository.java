package com.ucalp.sempar.repository;

import com.ucalp.sempar.entity.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface RepairsRepository extends JpaRepository<Repair, Long> {

}
