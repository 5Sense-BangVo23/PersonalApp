package com.dev.backend_api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.dev.backend_api.entity.UserEntity;
import com.dev.backend_api.listeners.CustomIdGenerator;
import com.dev.backend_api.repository.UserRepository;

@Configuration
public class RepoRegistrationConfig {

    @Autowired
    public RepoRegistrationConfig(UserRepository userRepo) {
        CustomIdGenerator.registerRepo(UserEntity.class, userRepo);
    }
}

