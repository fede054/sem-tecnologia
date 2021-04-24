package com.ucalp.sempar.dto.rs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProvinceRsDTO {

    private Long id;
    private String provinceCode;
    private String details;

}
