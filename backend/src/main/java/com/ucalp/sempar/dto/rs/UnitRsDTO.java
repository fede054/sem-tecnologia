package com.ucalp.sempar.dto.rs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnitRsDTO {

    private Long id;
    private String patent;
    private LocalDate patentDate;
    private Integer bedSeatsAmount;
    private Integer semiBedSeatsAmount;
    private UnitTypeRsDTO unitType;
    private List<RepairRsDTO> repairs;

}
