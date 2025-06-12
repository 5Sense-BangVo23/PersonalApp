package com.dev.backend_api.service.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.dev.backend_api.constants.EmailConstants;
import com.dev.backend_api.entity.exception.ApiException;
import com.dev.backend_api.service.EmailService;
import static com.dev.backend_api.utils.EmailUtils.getEmailMessage;
import static com.dev.backend_api.utils.EmailUtils.getResetPasswordMessage;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(EmailServiceImpl.class);
    private final JavaMailSender sender;

    @Value("${spring.mail.verify.host}")
    private String host;

    @Value("${spring.mail.username}")
    private static String fromEmail;



    @Override
    @Async
    public void sendNewAccountEmail(String name, String toEmail, String token) {
       try{
        SimpleMailMessage message = new SimpleMailMessage();

        message.setSubject(EmailConstants.NEW_USER_ACCOUNT_VERIFICATION);
        message.setFrom(fromEmail);
        message.setTo(toEmail);
        message.setText(getEmailMessage(name,host, token));

        sender.send(message);

       }catch (Exception e) {
            log.error("Error sending new account email to {}: {}", toEmail, e.getMessage());
            throw new ApiException("Unable to send email. Please try again later.");
        }
       
       
    }

    @Override
    @Async
    public void sendPasswordResetEmail(String name, String toEmail, String token) {
        try{
        SimpleMailMessage message = new SimpleMailMessage();

        message.setSubject(EmailConstants.PASSWORD_RESET_REQUEST);
        message.setFrom(fromEmail);
        message.setTo(toEmail);
        message.setText(getResetPasswordMessage(name,host, token));

        sender.send(message);

       }catch (Exception e) {
            log.error("Error sending new account email to {}: {}", toEmail, e.getMessage());
            throw new ApiException("Unable to send email. Please try again later.");
        }
    }

    public static String getVerificationUrl(String host, String token) {
        if (host == null || host.isBlank() || token == null || token.isBlank()) {
            throw new IllegalArgumentException("Host and token must not be null or empty.");
        }

        if (host.endsWith("/")) {
            host = host.substring(0, host.length() - 1);
        }

        return host + "/api/v1/auth/verify?token=" + token;
    }

     public static String getResetPasswordUrl(String host, String token) {
        if (host == null || host.isBlank() || token == null || token.isBlank()) {
            throw new IllegalArgumentException("Host and token must not be null or empty.");
        }

        if (host.endsWith("/")) {
            host = host.substring(0, host.length() - 1);
        }

        return host + "/api/v1/auth/reset-password?token=" + token;
    }
    
}
