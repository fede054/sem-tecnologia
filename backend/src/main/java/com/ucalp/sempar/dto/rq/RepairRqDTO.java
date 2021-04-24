package com.ucalp.sempar.dto.rq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepairRqDTO {
    
    private Integer repairTime;
    private String details;

}
