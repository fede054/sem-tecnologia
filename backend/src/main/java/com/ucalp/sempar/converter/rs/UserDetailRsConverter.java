package com.ucalp.sempar.converter.rs;

import com.ucalp.sempar.dto.rs.UserDetailRsDTO;
import com.ucalp.sempar.entity.Log;
import com.ucalp.sempar.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserDetailRsConverter implements Converter<User, UserDetailRsDTO> {

    @Override
    public UserDetailRsDTO convert(final User rsToConvert) {
        final UserDetailRsDTO convertedRs = new UserDetailRsDTO();
        convertedRs.setUserId(rsToConvert.getId());
        convertedRs.setName(rsToConvert.getName());
        convertedRs.setSurname(rsToConvert.getSurname());
        convertedRs.setEmail(rsToConvert.getEmail());
        convertedRs.setLogs(rsToConvert.getLogs().stream().map(Log::getAdmissionDateTime).collect(Collectors.toList()));
        return convertedRs;
    }

}
