package com.ucalp.sempar.converter.rq;

import com.ucalp.sempar.dto.rq.StationRqDTO;
import com.ucalp.sempar.entity.Station;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StationRqConverter implements Converter<StationRqDTO, Station> {

    @Override
    public Station convert(final StationRqDTO rqToConvert) {
        final Station convertedRq = new Station();
        convertedRq.setAddress(rqToConvert.getAddress());
        convertedRq.setPhoneNumber(rqToConvert.getPhoneNumber());
        return convertedRq;
    }

}
