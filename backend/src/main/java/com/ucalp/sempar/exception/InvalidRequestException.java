package com.ucalp.sempar.exception;

import com.ucalp.sempar.enums.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InvalidRequestException extends BaseException {

    private ErrorType code;
    private String description;

}
