package com.ucalp.sempar.service.impl;

import com.ucalp.sempar.converter.rq.RepairRqConverter;
import com.ucalp.sempar.converter.rs.RepairRsConverter;
import com.ucalp.sempar.dto.rq.RepairRqDTO;
import com.ucalp.sempar.dto.rs.RepairRsDTO;
import com.ucalp.sempar.entity.Repair;
import com.ucalp.sempar.entity.Unit;
import com.ucalp.sempar.enums.ErrorType;
import com.ucalp.sempar.exception.BaseException;
import com.ucalp.sempar.exception.InvalidRequestException;
import com.ucalp.sempar.repository.RepairsRepository;
import com.ucalp.sempar.repository.UnitsRepository;
import com.ucalp.sempar.service.RepairsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RepairsServiceImpl implements RepairsService {

    private final RepairsRepository repairsRepository;
    private final UnitsRepository unitsRepository;
    private final RepairRqConverter repairRqConverter;
    private final RepairRsConverter repairRsConverter;

    @Autowired
    private RepairsServiceImpl(final RepairsRepository repairsRepository,
                               final UnitsRepository unitsRepository,
                               final RepairRqConverter repairRqConverter,
                               final RepairRsConverter repairRsConverter) {
        this.repairsRepository = repairsRepository;
        this.unitsRepository = unitsRepository;
        this.repairRqConverter = repairRqConverter;
        this.repairRsConverter = repairRsConverter;
    }


    @Override
    public RepairRsDTO createRepair(final Long unitId, final RepairRqDTO repairToCreate) throws BaseException {
        final Optional<Unit> searchedUnit = this.unitsRepository.findById(unitId);
        if (searchedUnit.isPresent()) {
            final Repair convertedRepairToCreate = this.repairRqConverter.convert(repairToCreate);
            convertedRepairToCreate.setUnit(searchedUnit.get());
            final Repair savedRepair = this.repairsRepository.save(convertedRepairToCreate);
            return this.repairRsConverter.convert(savedRepair);
        } else {
            throw new InvalidRequestException(ErrorType.UNIT_INVALID_REQUEST, "Unit does not exist");
        }
    }

    @Override
    public RepairRsDTO updateRepair(final Long repairId, final RepairRqDTO updatedData) throws BaseException {
        final Optional<Repair> searchedRepair = this.repairsRepository.findById(repairId);
        if (searchedRepair.isPresent()) {
            final Repair repairToUpdate = searchedRepair.get();
            repairToUpdate.setDetails(updatedData.getDetails());
            repairToUpdate.setRepairTime(updatedData.getRepairTime());
            final Repair savedRepair = this.repairsRepository.save(repairToUpdate);
            return this.repairRsConverter.convert(savedRepair);
        } else {
            throw new InvalidRequestException(ErrorType.REPAIR_INVALID_REQUEST, "Repair does not exist");
        }
    }
}
