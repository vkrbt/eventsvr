package com.eventsvr.login.service;

import com.eventsvr.login.user.EventsVrUser;

public interface UserService {
    EventsVrUser findByLogin(String login);

    EventsVrUser save(EventsVrUser user);
}
