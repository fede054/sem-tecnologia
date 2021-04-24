package com.ucalp.sempar.repository;

import com.ucalp.sempar.entity.UnitType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UnitTypesRepository extends JpaRepository<UnitType, Long> {

}
