package com.ucalp.sempar.service;

import com.ucalp.sempar.dto.rq.RepairRqDTO;
import com.ucalp.sempar.dto.rs.RepairRsDTO;
import com.ucalp.sempar.exception.BaseException;

public interface RepairsService {

    public RepairRsDTO createRepair(final Long unitId,
                                    final RepairRqDTO repairToCreate) throws BaseException;

    public RepairRsDTO updateRepair(final Long repairId,
                                    final RepairRqDTO updatedData) throws BaseException;

}
