package com.ucalp.sempar.dto.rs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StationRsDTO {

    private Long id;
    private LocalityRsDTO locality;
    private String address;
    private String phoneNumber;

}
