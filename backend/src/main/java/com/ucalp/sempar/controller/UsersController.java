package com.ucalp.sempar.controller;

import com.ucalp.sempar.dto.rq.UserRqDTO;
import com.ucalp.sempar.dto.rs.AdmissionLogRsDTO;
import com.ucalp.sempar.dto.rs.UserDetailRsDTO;
import com.ucalp.sempar.exception.BaseException;
import com.ucalp.sempar.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    private UsersController(final UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> createUser(@RequestBody final UserRqDTO userData) {
        return new ResponseEntity<>(this.usersService.createUser(userData), HttpStatus.OK);
    }

    @PostMapping(
            value = "/{userId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdmissionLogRsDTO> createUser(@PathVariable final Long userId) throws BaseException {
        return new ResponseEntity<>(this.usersService.createLog(userId), HttpStatus.OK);
    }

    @GetMapping(
            value = "/log",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDetailRsDTO>> retrieveLogs(@RequestParam(required = false) final String name,
                                                              @RequestParam(required = false) final String surname) throws BaseException {
        return new ResponseEntity<>(this.usersService.retrieveLogs(name, surname), HttpStatus.OK);
    }

}
