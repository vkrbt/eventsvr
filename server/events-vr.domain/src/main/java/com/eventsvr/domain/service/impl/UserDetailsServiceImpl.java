package com.eventsvr.domain.service.impl;

import com.eventsvr.domain.service.UserService;
import com.eventsvr.domain.user.EventsVrUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EventsVrUser applicationUser = userService.findByLogin(username);

        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(applicationUser.getLogin(), applicationUser.getPassword(), new ArrayList<>());
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
