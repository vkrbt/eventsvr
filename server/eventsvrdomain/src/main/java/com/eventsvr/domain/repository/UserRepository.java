package com.eventsvr.domain.repository;

import com.eventsvr.domain.user.EventsVrUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<EventsVrUser, Long> {
    EventsVrUser findByLogin(String login);
}
