package com.dev.backend_api.utils;

import java.time.LocalDateTime;
import java.util.Map;

import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;

import com.dev.backend_api.domain.Response;

import jakarta.servlet.http.HttpServletRequest;
public class RequestUtils {

    public static Response getResponse(HttpServletRequest request, Map<?,?> data, String message, HttpStatus status) {
        return new Response(
            LocalDateTime.now().toString(),
            status.value(),
            request.getRequestURI(),
            HttpStatus.valueOf(status.value()),
            message,
            Strings.EMPTY,
            data
        );
    }
    
}
