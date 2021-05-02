package com.ucalp.sempar.converter.rq;

import com.ucalp.sempar.dto.rq.UserRqDTO;
import com.ucalp.sempar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class UserRqConverter implements Converter<UserRqDTO, User> {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserRqConverter(final PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User convert(final UserRqDTO rqToConvert) {
        final User userToCreate = new User();
        userToCreate.setUsername(rqToConvert.getUsername());
        userToCreate.setPassword(this.passwordEncoder.encode(rqToConvert.getPassword()));
        userToCreate.setName(rqToConvert.getName());
        userToCreate.setSurname(rqToConvert.getSurname());
        userToCreate.setEmail(rqToConvert.getEmail());
        userToCreate.setLogs(Collections.emptyList());
        return userToCreate;
    }

}
