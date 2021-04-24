package com.ucalp.sempar.controller;

import com.ucalp.sempar.dto.rq.UserRqDTO;
import com.ucalp.sempar.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    private UsersController(final UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping(
            path = "/authenticate",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> authenticate(@RequestBody final UserRqDTO userData) {
        final HttpStatus statusToReturn = this.usersService.authenticateUser(userData);
        return new ResponseEntity<>(statusToReturn, statusToReturn);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> createUser(@RequestBody final UserRqDTO userData) {
        return new ResponseEntity<>(this.usersService.createUser(userData), HttpStatus.OK);
    }

}
