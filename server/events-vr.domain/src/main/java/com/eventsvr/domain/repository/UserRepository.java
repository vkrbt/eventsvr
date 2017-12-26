package com.eventsvr.domain.repository;

import com.eventsvr.domain.user.EventsVrUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<EventsVrUser, UUID> {
    EventsVrUser findByLogin(String login);
}
