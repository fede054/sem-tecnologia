package com.ucalp.sempar.dto.rq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StationRqDTO {

    private Long localityId;
    private String address;
    private String phoneNumber;

}
