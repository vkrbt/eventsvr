package com.eventsvr.login.service.impl;

import com.eventsvr.login.repository.UserRepository;
import com.eventsvr.login.service.UserService;
import com.eventsvr.login.user.EventsVrUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    private UserRepository userRepository;

    @Override
    public EventsVrUser findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public EventsVrUser save(EventsVrUser user) {
        if (userRepository.findByLogin(user.getLogin()) == null) {
            userRepository.save(user);
            return user;
        }

        return null;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
