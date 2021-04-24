package com.ucalp.sempar.dto.rs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalityRsDTO {
    
    private Long id;
    private Integer postalCode;
    private String details;
    private ProvinceRsDTO province;

}
