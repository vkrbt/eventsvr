package com.eventsvr.domain.service.impl;

import com.eventsvr.domain.repository.UserRepository;
import com.eventsvr.domain.user.EventsVrUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventsvr.domain.service.UserService;

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
