package com.ucalp.sempar.service;

import com.ucalp.sempar.dto.rq.UserRqDTO;
import com.ucalp.sempar.dto.rs.AdmissionLogRsDTO;
import com.ucalp.sempar.dto.rs.UserDetailRsDTO;
import com.ucalp.sempar.exception.BaseException;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface UsersService {

    public HttpStatus createUser(final UserRqDTO user);

    public AdmissionLogRsDTO createLog(final Long userId) throws BaseException;

    public List<UserDetailRsDTO> retrieveLogs(final String name,
                                              final String surname);

}
