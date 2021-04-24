package com.ucalp.sempar.controller;

import com.ucalp.sempar.dto.rq.RepairRqDTO;
import com.ucalp.sempar.dto.rq.UnitRqDTO;
import com.ucalp.sempar.dto.rs.RepairRsDTO;
import com.ucalp.sempar.dto.rs.UnitRsDTO;
import com.ucalp.sempar.exception.BaseException;
import com.ucalp.sempar.service.RepairsService;
import com.ucalp.sempar.service.UnitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/unit")
public class UnitsController {

    private final UnitsService unitsService;
    private final RepairsService repairsService;

    @Autowired
    private UnitsController(final UnitsService unitsService,
                            final RepairsService repairsService) {
        this.unitsService = unitsService;
        this.repairsService = repairsService;
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UnitRsDTO>> retrieveUnits() {
        return new ResponseEntity<>(this.unitsService.retrieveUnits(), HttpStatus.OK);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UnitRsDTO> createUnit(@RequestBody final UnitRqDTO unitToCreate) throws BaseException {
        return new ResponseEntity<>(this.unitsService.createUnit(unitToCreate), HttpStatus.OK);
    }

    @PutMapping(
            value = "/{unitId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UnitRsDTO> updateUnit(@PathVariable final Long unitId,
                                                @RequestBody final UnitRqDTO updatedData) throws BaseException {
        return new ResponseEntity<>(this.unitsService.updateUnit(unitId, updatedData), HttpStatus.OK);
    }

    @PostMapping(
            value = "/{unitId}/repair",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RepairRsDTO> createRepair(@PathVariable final Long unitId,
                                                    @RequestBody final RepairRqDTO repairToCreate) throws BaseException {
        return new ResponseEntity<>(this.repairsService.createRepair(unitId, repairToCreate), HttpStatus.OK);
    }

    @PutMapping(
            value = "/repair/{repairId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RepairRsDTO> updateRepair(@PathVariable final Long repairId,
                                                    @RequestBody final RepairRqDTO repairToCreate) throws BaseException {
        return new ResponseEntity<>(this.repairsService.updateRepair(repairId, repairToCreate), HttpStatus.OK);
    }

}
