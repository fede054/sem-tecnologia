package com.ucalp.sempar.converter.rs;

import com.ucalp.sempar.dto.rs.RepairRsDTO;
import com.ucalp.sempar.dto.rs.UnitRsDTO;
import com.ucalp.sempar.dto.rs.UnitTypeRsDTO;
import com.ucalp.sempar.entity.Repair;
import com.ucalp.sempar.entity.Unit;
import com.ucalp.sempar.entity.UnitType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RepairRsConverter implements Converter<Repair, RepairRsDTO> {

    @Override
    public RepairRsDTO convert(final Repair rsToConvert) {
        final RepairRsDTO convertedRs = new RepairRsDTO();
        convertedRs.setId(rsToConvert.getId());
        convertedRs.setRepairTime(rsToConvert.getRepairTime());
        convertedRs.setDetails(rsToConvert.getDetails());
        convertedRs.setUnit(convertUnit(rsToConvert.getUnit()));
        return convertedRs;
    }

    private UnitRsDTO convertUnit(final Unit unitToConvert) {
        final UnitRsDTO convertedUnit = new UnitRsDTO();
        convertedUnit.setId(unitToConvert.getId());
        convertedUnit.setPatent(unitToConvert.getPatent());
        convertedUnit.setBedSeatsAmount(unitToConvert.getBedSeatsAmount());
        convertedUnit.setPatentDate(unitToConvert.getPatentDate());
        convertedUnit.setSemiBedSeatsAmount(unitToConvert.getSemiBedSeatsAmount());
        convertedUnit.setUnitType(convertUnitType(unitToConvert.getUnitType()));
        return convertedUnit;
    }

    private static UnitTypeRsDTO convertUnitType(final UnitType unitTypeToConvert) {
        final UnitTypeRsDTO convertedUnitType = new UnitTypeRsDTO();
        convertedUnitType.setId(unitTypeToConvert.getId());
        convertedUnitType.setDescription(unitTypeToConvert.getDescription());
        return convertedUnitType;
    }

}
