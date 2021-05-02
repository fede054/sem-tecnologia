package com.ucalp.sempar.service.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.ucalp.sempar.converter.rq.UserRqConverter;
import com.ucalp.sempar.converter.rs.AdmissionLogRsConverter;
import com.ucalp.sempar.converter.rs.UserDetailRsConverter;
import com.ucalp.sempar.dto.rq.UserRqDTO;
import com.ucalp.sempar.dto.rs.AdmissionLogRsDTO;
import com.ucalp.sempar.dto.rs.UserDetailRsDTO;
import com.ucalp.sempar.entity.Log;
import com.ucalp.sempar.entity.QUser;
import com.ucalp.sempar.entity.User;
import com.ucalp.sempar.exception.BaseException;
import com.ucalp.sempar.exception.InvalidRequestException;
import com.ucalp.sempar.repository.LogRepository;
import com.ucalp.sempar.repository.UserRepository;
import com.ucalp.sempar.service.UsersService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    private final UserRepository userRepository;
    private final LogRepository logRepository;
    private final UserRqConverter userRqConverter;
    private final AdmissionLogRsConverter admissionLogRsConverter;
    private final UserDetailRsConverter userDetailRsConverter;

    @Autowired
    private UsersServiceImpl(final UserRepository userRepository,
                             final LogRepository logRepository,
                             final UserRqConverter userRqConverter,
                             final AdmissionLogRsConverter admissionLogRsConverter,
                             final UserDetailRsConverter userDetailRsConverter) {
        this.userRepository = userRepository;
        this.logRepository = logRepository;
        this.userRqConverter = userRqConverter;
        this.admissionLogRsConverter = admissionLogRsConverter;
        this.userDetailRsConverter = userDetailRsConverter;
    }

    @Override
    public HttpStatus createUser(final UserRqDTO user) {
        final Optional<User> existingUser = this.userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            return HttpStatus.BAD_REQUEST;
        }
        this.userRepository.save(this.userRqConverter.convert(user));
        return HttpStatus.OK;
    }

    @Override
    public AdmissionLogRsDTO createLog(final Long userId) throws BaseException {
        final Optional<User> existingUser = this.userRepository.findById(userId);
        if (existingUser.isPresent()) {
            final User retrievedUser = existingUser.get();
            final Log logToCreate = new Log(null, existingUser.get(), null);
            retrievedUser.getLogs().add(logToCreate);
            final Log savedLog = this.logRepository.save(logToCreate);
            return this.admissionLogRsConverter.convert(savedLog);
        } else {
            throw new InvalidRequestException("User with id: " + userId + " does not exist");
        }
    }

    @Override
    public List<UserDetailRsDTO> retrieveLogs(final String name,
                                              final String surname) {
        final Iterable<User> existingUser = this.userRepository.findAll(buildPredicateForUser(name, surname));
        final List<UserDetailRsDTO> convertedUsers = new ArrayList<>();
        existingUser.iterator().forEachRemaining(user -> convertedUsers.add(this.userDetailRsConverter.convert(user)));
        return convertedUsers;
    }

    private Predicate buildPredicateForUser(final String name,
                                            final String surname) {
        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        final QUser qUser = QUser.user;
        if (name != null && !StringUtils.isEmpty(name)) {
            booleanBuilder.and(qUser.name.containsIgnoreCase(name));
        }
        if (surname != null && !StringUtils.isEmpty(surname)) {
            booleanBuilder.and(qUser.surname.containsIgnoreCase(surname));
        }
        return booleanBuilder;
    }

}
