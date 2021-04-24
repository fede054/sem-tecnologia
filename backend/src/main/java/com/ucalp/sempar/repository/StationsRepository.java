package com.ucalp.sempar.repository;

import com.ucalp.sempar.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface StationsRepository extends JpaRepository<Station, Long> {

}
