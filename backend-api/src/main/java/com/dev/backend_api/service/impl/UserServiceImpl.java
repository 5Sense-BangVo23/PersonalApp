package com.dev.backend_api.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import static com.dev.backend_api.constants.MessageConstants.ROLE_NOT_FOUND;
import com.dev.backend_api.entity.ConfirmationEntity;
import com.dev.backend_api.entity.CredentialEntity;
import com.dev.backend_api.entity.RoleEntity;
import com.dev.backend_api.entity.UserEntity;
import com.dev.backend_api.entity.exception.ApiException;
import com.dev.backend_api.enumeration.Authority;
import com.dev.backend_api.enumeration.EventType;
import com.dev.backend_api.event.UserEvent;
import com.dev.backend_api.repository.ConfirmationRepository;
import com.dev.backend_api.repository.CredentialRepository;
import com.dev.backend_api.repository.RoleRepository;
import com.dev.backend_api.repository.UserRepository;
import com.dev.backend_api.service.UserService;
import static com.dev.backend_api.utils.UserUtils.createUserEntity;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    
    private final UserRepository userRepository; // Assuming you have a UserRepository for database operations
    private final RoleRepository roleRepository; // Assuming you have a RoleRepository for role management
    private final CredentialRepository credentialRepository; // Assuming you have a CredentialRepository for credential management
    private final ConfirmationRepository confirmationRepository; // Assuming you have a ConfirmationRepository for confirmation management

    // private final BCryptPasswordEncoder passwordEncoder ;

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void createUser(String firstName, String lastName, String email, String password) {
        var userEntity = userRepository.save(createNewUser(firstName, lastName, email, password));
        var  credentialEntity = new CredentialEntity(password, userEntity);
        credentialRepository.save(credentialEntity);
        var confirmationEntity = new ConfirmationEntity(userEntity);
        confirmationRepository.save(confirmationEntity);
        eventPublisher.publishEvent(new UserEvent(userEntity, EventType.REGISTRATION, Map.of("key", confirmationEntity.getKey())));

    }

    

    @Override
    public RoleEntity getRoleName(String name) {
        var role = roleRepository.findByNameIgnoreCase(name);
        return role.orElseThrow(() -> new ApiException(ROLE_NOT_FOUND));
    }



    private UserEntity createNewUser(String firstName, String lastName, String email, String password) {
       var role = getRoleName(Authority.USER.name());

       return createUserEntity(firstName, lastName, email, role);
    }


   
}
