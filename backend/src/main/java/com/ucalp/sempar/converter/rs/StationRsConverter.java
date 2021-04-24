package com.ucalp.sempar.converter.rs;

import com.ucalp.sempar.dto.rs.LocalityRsDTO;
import com.ucalp.sempar.dto.rs.ProvinceRsDTO;
import com.ucalp.sempar.dto.rs.StationRsDTO;
import com.ucalp.sempar.entity.Locality;
import com.ucalp.sempar.entity.Province;
import com.ucalp.sempar.entity.Station;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StationRsConverter implements Converter<Station, StationRsDTO> {

    @Override
    public StationRsDTO convert(final Station rsToConvert) {
        final StationRsDTO convertedRs = new StationRsDTO();
        convertedRs.setId(rsToConvert.getId());
        convertedRs.setAddress(rsToConvert.getAddress());
        convertedRs.setPhoneNumber(rsToConvert.getPhoneNumber());
        convertedRs.setLocality(convertLocality(rsToConvert.getLocality()));
        return convertedRs;
    }

    private LocalityRsDTO convertLocality(final Locality localityToConvert) {
        final LocalityRsDTO convertedLocality = new LocalityRsDTO();
        convertedLocality.setId(localityToConvert.getId());
        convertedLocality.setPostalCode(localityToConvert.getPostalCode());
        convertedLocality.setDetails(localityToConvert.getDetails());
        convertedLocality.setProvince(convertProvince(localityToConvert.getProvince()));
        return convertedLocality;
    }

    private ProvinceRsDTO convertProvince(final Province provinceToConvert) {
        final ProvinceRsDTO convertedProvince = new ProvinceRsDTO();
        convertedProvince.setId(provinceToConvert.getId());
        convertedProvince.setProvinceCode(provinceToConvert.getProvinceCode());
        convertedProvince.setDetails(provinceToConvert.getDetails());
        return convertedProvince;
    }

}
