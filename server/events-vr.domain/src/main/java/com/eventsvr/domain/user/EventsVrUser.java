package com.eventsvr.domain.user;

import com.datastax.driver.core.utils.UUIDs;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import java.util.UUID;

@Table("users")
public class EventsVrUser {
    public EventsVrUser() {
        this.id = UUIDs.timeBased();
    }

    @PrimaryKeyColumn(name = "id", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private UUID id;

//    @PrimaryKeyColumn(name = "login", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String login;

    private String password;

    private String email;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
