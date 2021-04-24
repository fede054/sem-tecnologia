package com.ucalp.sempar.dto.rq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnitRqDTO {
    
    private String patent;
    private LocalDate patentDate;
    private Integer bedSeatsAmount;
    private Integer semiBedSeatsAmount;
    private Long unitTypeId;

}
