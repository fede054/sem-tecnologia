package com.ucalp.sempar.service.impl;

import com.ucalp.sempar.dto.rq.UserRqDTO;
import com.ucalp.sempar.entity.User;
import com.ucalp.sempar.repository.UsersRepository;
import com.ucalp.sempar.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UsersServiceImpl(final UsersRepository usersRepository,
                             final PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public HttpStatus authenticateUser(final UserRqDTO user) {
        final Optional<User> existingUser = this.usersRepository.findById(user.getUsername());
        if (existingUser.isPresent()) {
            final User retrievedUser = existingUser.get();
            final boolean matchesPass = this.passwordEncoder.matches(user.getPassword(), retrievedUser.getPassword());
            if (matchesPass) {
                return HttpStatus.OK;
            }
        }
        return HttpStatus.UNAUTHORIZED;
    }

    @Override
    public HttpStatus createUser(final UserRqDTO user) {
        final Optional<User> existingUser = this.usersRepository.findById(user.getUsername());
        if (existingUser.isPresent()) {
            return HttpStatus.BAD_REQUEST;
        }
        this.usersRepository.save(new User(user.getUsername(), this.passwordEncoder.encode(user.getPassword())));
        return HttpStatus.OK;
    }
}
