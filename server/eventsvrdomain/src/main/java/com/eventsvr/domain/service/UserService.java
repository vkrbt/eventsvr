package com.eventsvr.domain.service;

import com.eventsvr.domain.user.EventsVrUser;

public interface UserService {
    EventsVrUser findByLogin(String login);

    EventsVrUser save(EventsVrUser user);
}
