package com.eventsvr.login.controller;

import com.eventsvr.login.controller.dao.AuthResponse;
import com.eventsvr.login.repository.UserRepository;
import com.eventsvr.login.service.UserService;
import com.eventsvr.login.user.EventsVrUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoginController {
    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/registration")
    public ResponseEntity<AuthResponse> registration(@RequestBody EventsVrUser user) {
        AuthResponse response = new AuthResponse();

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if (userService.findByLogin(user.getLogin()) == null) {
            userService.save(user);

            response.setStatus(HttpStatus.OK);
            response.setMessage("successful registration");
            response.setTimestamp(new Date());

            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        response.setMessage("login already exists");
        response.setStatus(HttpStatus.FORBIDDEN);
        response.setTimestamp(new Date());

        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
}
