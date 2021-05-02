package com.ucalp.sempar.dto.rs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdmissionLogRsDTO {

    private Long userId;
    private String name;
    private String surname;
    private String email;
    private LocalDateTime admissionDateTime;

}
