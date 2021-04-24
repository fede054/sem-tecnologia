package com.ucalp.sempar.service;

import com.ucalp.sempar.dto.rq.UnitRqDTO;
import com.ucalp.sempar.dto.rs.UnitRsDTO;
import com.ucalp.sempar.exception.BaseException;

import java.util.List;

public interface UnitsService {

    public List<UnitRsDTO> retrieveUnits();

    public UnitRsDTO createUnit(final UnitRqDTO unitToCreate) throws BaseException;

    public UnitRsDTO updateUnit(final Long unitId,
                                final UnitRqDTO updatedData) throws BaseException;

}
