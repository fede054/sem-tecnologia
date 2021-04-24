package com.ucalp.sempar.service;

import com.ucalp.sempar.dto.rq.UserRqDTO;
import org.springframework.http.HttpStatus;

public interface UsersService {

    public HttpStatus authenticateUser(final UserRqDTO user);

    public HttpStatus createUser(final UserRqDTO user);

}
