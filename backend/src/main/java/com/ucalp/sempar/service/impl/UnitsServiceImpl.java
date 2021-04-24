package com.ucalp.sempar.service.impl;

import com.ucalp.sempar.converter.rq.UnitRqConverter;
import com.ucalp.sempar.converter.rs.UnitRsConverter;
import com.ucalp.sempar.dto.rq.UnitRqDTO;
import com.ucalp.sempar.dto.rs.UnitRsDTO;
import com.ucalp.sempar.entity.Unit;
import com.ucalp.sempar.entity.UnitType;
import com.ucalp.sempar.enums.ErrorType;
import com.ucalp.sempar.exception.BaseException;
import com.ucalp.sempar.exception.InvalidRequestException;
import com.ucalp.sempar.repository.UnitTypesRepository;
import com.ucalp.sempar.repository.UnitsRepository;
import com.ucalp.sempar.service.UnitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UnitsServiceImpl implements UnitsService {

    private final UnitsRepository unitsRepository;
    private final UnitTypesRepository unitTypesRepository;
    private final UnitRqConverter unitRqConverter;
    private final UnitRsConverter unitRsConverter;

    @Autowired
    private UnitsServiceImpl(final UnitsRepository unitsRepository,
                             final UnitTypesRepository unitTypesRepository,
                             final UnitRqConverter unitRqConverter,
                             final UnitRsConverter unitRsConverter) {
        this.unitsRepository = unitsRepository;
        this.unitTypesRepository = unitTypesRepository;
        this.unitRqConverter = unitRqConverter;
        this.unitRsConverter = unitRsConverter;
    }


    @Override
    public List<UnitRsDTO> retrieveUnits() {
        return this.unitsRepository.findAll().stream().map(this.unitRsConverter::convert).collect(Collectors.toList());
    }

    @Override
    public UnitRsDTO createUnit(final UnitRqDTO unitToCreate) throws BaseException {
        final Optional<Unit> existingUnit = this.unitsRepository.findByPatent(unitToCreate.getPatent());
        if (existingUnit.isPresent()) {
            throw new InvalidRequestException(ErrorType.UNIT_INVALID_REQUEST, "Unit already exists");
        }
        final Unit convertedUnit = this.unitRqConverter.convert(unitToCreate);
        final Optional<UnitType> associatedType = this.unitTypesRepository.findById(unitToCreate.getUnitTypeId());
        if (associatedType.isPresent()) {
            convertedUnit.setUnitType(associatedType.get());
        } else {
            throw new InvalidRequestException(ErrorType.UNIT_INVALID_REQUEST, "UnitType does not exist");
        }
        final Unit savedUnit = this.unitsRepository.save(convertedUnit);
        return this.unitRsConverter.convert(savedUnit);
    }

    @Override
    public UnitRsDTO updateUnit(final Long unitId, final UnitRqDTO updatedData) throws BaseException {
        final Optional<Unit> searchedUnit = this.unitsRepository.findById(unitId);
        if (searchedUnit.isPresent()) {
            final Unit unitToUpdate = searchedUnit.get();
            if (updatedData.getUnitTypeId() != null) {
                final Optional<UnitType> searchedUnitType = this.unitTypesRepository.findById(updatedData.getUnitTypeId());
                if (!searchedUnitType.isPresent()) {
                    throw new InvalidRequestException(ErrorType.UNIT_INVALID_REQUEST, "UnitType does not exist");
                }
                unitToUpdate.setUnitType(searchedUnitType.get());
            }
            unitToUpdate.setPatent(updatedData.getPatent());
            unitToUpdate.setPatentDate(updatedData.getPatentDate());
            unitToUpdate.setBedSeatsAmount(updatedData.getBedSeatsAmount());
            unitToUpdate.setSemiBedSeatsAmount(updatedData.getSemiBedSeatsAmount());
            final Unit updatedUnit = this.unitsRepository.save(unitToUpdate);
            return this.unitRsConverter.convert(updatedUnit);
        } else {
            throw new InvalidRequestException(ErrorType.UNIT_INVALID_REQUEST, "Unit does not exist");
        }
    }

}
