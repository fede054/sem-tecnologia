package com.ucalp.sempar.converter.rq;

import com.ucalp.sempar.dto.rq.RepairRqDTO;
import com.ucalp.sempar.entity.Repair;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RepairRqConverter implements Converter<RepairRqDTO, Repair> {

    @Override
    public Repair convert(final RepairRqDTO rqToConvert) {
        final Repair convertedRq = new Repair();
        convertedRq.setRepairTime(rqToConvert.getRepairTime());
        convertedRq.setDetails(rqToConvert.getDetails());
        return convertedRq;
    }

}
