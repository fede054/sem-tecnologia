package com.ucalp.sempar.controller;

import com.ucalp.sempar.dto.rq.StationRqDTO;
import com.ucalp.sempar.dto.rs.StationRsDTO;
import com.ucalp.sempar.exception.BaseException;
import com.ucalp.sempar.service.StationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/station")
public class StationsController {

    private final StationsService stationsService;

    @Autowired
    private StationsController(final StationsService stationsService) {
        this.stationsService = stationsService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StationRsDTO> createStation(@RequestBody final StationRqDTO stationData) throws BaseException {
        return new ResponseEntity<>(this.stationsService.createStation(stationData), HttpStatus.OK);
    }

}
