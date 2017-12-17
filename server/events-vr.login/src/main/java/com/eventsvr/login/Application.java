package com.eventsvr.login;

import com.eventsvr.domain.service.UserService;
import com.eventsvr.domain.service.impl.UserDetailsServiceImpl;
import com.eventsvr.domain.service.impl.UserServiceImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableCassandraRepositories("com.eventsvr.domain.repository")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetails() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImp();
    }
}
