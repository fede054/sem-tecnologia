package com.ucalp.sempar.enums;

public enum ErrorType {

    UNIT_INVALID_REQUEST("UNIT_001"),
    REPAIR_INVALID_REQUEST("REPAIR_001"),
    STATION_INVALID_REQUEST("STATION_001");

    private final String errorCode;

    ErrorType(final String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

}
