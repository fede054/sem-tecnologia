package com.ucalp.sempar.converter.rq;

import com.ucalp.sempar.dto.rq.UnitRqDTO;
import com.ucalp.sempar.entity.Unit;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UnitRqConverter implements Converter<UnitRqDTO, Unit> {

    @Override
    public Unit convert(final UnitRqDTO rqToConvert) {
        final Unit convertedRq = new Unit();
        convertedRq.setPatent(rqToConvert.getPatent());
        convertedRq.setBedSeatsAmount(rqToConvert.getBedSeatsAmount());
        convertedRq.setPatentDate(rqToConvert.getPatentDate());
        convertedRq.setSemiBedSeatsAmount(rqToConvert.getSemiBedSeatsAmount());
        return convertedRq;
    }

}
