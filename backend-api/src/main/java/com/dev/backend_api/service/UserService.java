package com.dev.backend_api.service;

import com.dev.backend_api.entity.RoleEntity;

public interface UserService {
    void createUser(String firstName, String lastName, String email, String password);

    //getRoleName
    RoleEntity getRoleName(String name);
}
