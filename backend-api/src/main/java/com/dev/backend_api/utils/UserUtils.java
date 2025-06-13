package com.dev.backend_api.utils;

import java.time.LocalDateTime;
import java.util.UUID;

import org.apache.logging.log4j.util.Strings;

import com.dev.backend_api.entity.RoleEntity;
import com.dev.backend_api.entity.UserEntity;

public class UserUtils {

    public static UserEntity createUserEntity(String firstName, String lastName, String email, RoleEntity role) {
        return UserEntity.builder()
                .userId(UUID.randomUUID().toString())
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .lastLogin(LocalDateTime.now())
                .accountNonExpired(true)         
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .loginAttempts(0)               
                .qrCodeSecret(Strings.EMPTY)     
                .phone(Strings.EMPTY)
                .bio(Strings.EMPTY)
                .imageUrl(Strings.EMPTY)
                .enabled(false)
                .role(role)
                .build();
    }
}
