package com.ucalp.sempar.dto.rs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailRsDTO {

    private Long userId;
    private String name;
    private String surname;
    private String email;
    private List<LocalDateTime> logs;

}
