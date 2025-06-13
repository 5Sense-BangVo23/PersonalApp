package com.dev.backend_api.resource;

import java.net.URI;
import java.time.LocalDateTime;
import static java.util.Collections.emptyMap;

import static org.springframework.http.HttpStatus.CREATED;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend_api.domain.Response;
import com.dev.backend_api.dtorequest.UserRequest;
import com.dev.backend_api.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = {"/user"})
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Response> saveUser(@RequestBody @Valid UserRequest userRequest, HttpServletRequest request) {
        userService.createUser(
            userRequest.getFirstName(),
            userRequest.getLastName(),
            userRequest.getEmail(),
            userRequest.getPassword()
        );

        URI location = getUri("/user/register");

        Response response = new Response(
            LocalDateTime.now().toString(),
            CREATED.value(),
            request.getRequestURI(),
            CREATED,
            "Account created successfully",
            null,
            emptyMap()
        );

        return ResponseEntity.created(location).body(response);
    }

    private URI getUri(String path) {
        return URI.create(path);
    }
}
