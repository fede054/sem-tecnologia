package com.ucalp.sempar.repository;

import com.ucalp.sempar.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UnitsRepository extends JpaRepository<Unit, Long> {

    public Optional<Unit> findByPatent(final String patent);

}
