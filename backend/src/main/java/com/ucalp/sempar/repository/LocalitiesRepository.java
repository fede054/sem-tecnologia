package com.ucalp.sempar.repository;

import com.ucalp.sempar.entity.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface LocalitiesRepository extends JpaRepository<Locality, Long> {

}
