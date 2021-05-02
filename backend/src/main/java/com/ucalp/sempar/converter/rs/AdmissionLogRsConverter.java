package com.ucalp.sempar.converter.rs;

import com.ucalp.sempar.dto.rs.AdmissionLogRsDTO;
import com.ucalp.sempar.entity.Log;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AdmissionLogRsConverter implements Converter<Log, AdmissionLogRsDTO> {

    @Override
    public AdmissionLogRsDTO convert(final Log rsToConvert) {
        final AdmissionLogRsDTO convertedRs = new AdmissionLogRsDTO();
        convertedRs.setName(rsToConvert.getUser().getName());
        convertedRs.setSurname(rsToConvert.getUser().getSurname());
        convertedRs.setEmail(rsToConvert.getUser().getEmail());
        convertedRs.setUserId(rsToConvert.getUser().getId());
        convertedRs.setAdmissionDateTime(rsToConvert.getAdmissionDateTime());
        return convertedRs;
    }

}
