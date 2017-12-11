package com.eventsvr.login.service.impl;

import com.eventsvr.login.service.UserService;
import com.eventsvr.login.user.EventsVrUser;
import org.springframework.beans.factory.annotation.Autowired;
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
