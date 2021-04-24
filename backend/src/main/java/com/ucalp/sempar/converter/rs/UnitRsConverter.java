package com.ucalp.sempar.converter.rs;

import com.ucalp.sempar.dto.rs.RepairRsDTO;
import com.ucalp.sempar.dto.rs.UnitRsDTO;
import com.ucalp.sempar.dto.rs.UnitTypeRsDTO;
import com.ucalp.sempar.entity.Repair;
import com.ucalp.sempar.entity.Unit;
import com.ucalp.sempar.entity.UnitType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UnitRsConverter implements Converter<Unit, UnitRsDTO> {


    @Override
    public UnitRsDTO convert(final Unit rsToConvert) {
        final UnitRsDTO convertedRs = new UnitRsDTO();
        convertedRs.setId(rsToConvert.getId());
        convertedRs.setPatent(rsToConvert.getPatent());
        convertedRs.setBedSeatsAmount(rsToConvert.getBedSeatsAmount());
        convertedRs.setPatentDate(rsToConvert.getPatentDate());
        convertedRs.setRepairs(convertRepairs(rsToConvert.getRepairs()));
        convertedRs.setSemiBedSeatsAmount(rsToConvert.getSemiBedSeatsAmount());
        convertedRs.setUnitType(convertUnitType(rsToConvert.getUnitType()));
        return convertedRs;
    }

    private static List<RepairRsDTO> convertRepairs(final List<Repair> repairsToConvert) {
        final List<RepairRsDTO> listToReturn;
        if (repairsToConvert != null && !repairsToConvert.isEmpty()) {
            listToReturn = repairsToConvert.stream().map(repair -> {
                final RepairRsDTO convertedRepair = new RepairRsDTO();
                convertedRepair.setId(repair.getId());
                convertedRepair.setDetails(repair.getDetails());
                convertedRepair.setRepairTime(repair.getRepairTime());
                return convertedRepair;
            }).collect(Collectors.toList());
        } else {
            listToReturn = null;
        }
        return listToReturn;
    }

    private static UnitTypeRsDTO convertUnitType(final UnitType unitTypeToConvert) {
        final UnitTypeRsDTO convertedUnitType = new UnitTypeRsDTO();
        convertedUnitType.setId(unitTypeToConvert.getId());
        convertedUnitType.setDescription(unitTypeToConvert.getDescription());
        return convertedUnitType;
    }

}
