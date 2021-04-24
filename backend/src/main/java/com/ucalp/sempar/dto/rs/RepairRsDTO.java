package com.ucalp.sempar.dto.rs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepairRsDTO {

    private Long id;
    private Integer repairTime;
    private String details;
    private UnitRsDTO unit;

}
