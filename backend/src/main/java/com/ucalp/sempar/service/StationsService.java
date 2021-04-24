package com.ucalp.sempar.service;

import com.ucalp.sempar.dto.rq.StationRqDTO;
import com.ucalp.sempar.dto.rs.StationRsDTO;
import com.ucalp.sempar.exception.BaseException;

public interface StationsService {

    public StationRsDTO createStation(final StationRqDTO stationData) throws BaseException;

}
