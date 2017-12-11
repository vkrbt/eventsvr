package com.eventsvr.login.repository;

import com.eventsvr.login.user.EventsVrUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<EventsVrUser, Long> {
    EventsVrUser findByLogin(String login);
}
