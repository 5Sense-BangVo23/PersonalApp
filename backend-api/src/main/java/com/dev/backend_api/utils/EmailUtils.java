package com.dev.backend_api.utils;

public class EmailUtils {

    public static String getEmailMessage(String name, String host, String token) {
        return "<div style='font-family:Arial,sans-serif;font-size:14px;'>"
                + "<h2>Hello " + name + ",</h2>"
                + "<p>Thank you for registering. Please click the link below to verify your email address:</p>"
                + "<a href=\"" + host + "/api/v1/auth/verify?token=" + token + "\">Verify Your Account</a>"
                + "<br/><br/>"
                + "<p>If you did not request this, you can safely ignore this email.</p>"
                + "<p>Best regards,<br/>Support Team</p>"
                + "</div>";
    }

    public static String getResetPasswordMessage(String name, String host, String token) {
        return "<div style='font-family:Arial,sans-serif;font-size:14px;'>"
                + "<h2>Hello " + name + ",</h2>"
                + "<p>We received a request to reset your password. Please click the link below to reset it:</p>"
                + "<a href=\"" + host + "/api/v1/auth/reset-password?token=" + token + "\">Reset Your Password</a>"
                + "<br/><br/>"
                + "<p>If you did not request this, you can safely ignore this email.</p>"
                + "<p>Best regards,<br/>Support Team</p>"
                + "</div>";
    }




}
