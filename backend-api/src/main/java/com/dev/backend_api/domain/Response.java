package com.dev.backend_api.domain;

import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@JsonInclude(NON_DEFAULT)
public record Response(String time, int code, String path, HttpStatus status, String message, String exception, Map<?,?> data) {
    
}
