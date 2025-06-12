package com.dev.backend_api.domain;

public class RequestContext {

    private static final ThreadLocal<String> USER_ID = new ThreadLocal<>();

    private RequestContext() {
        // Private constructor để tránh khởi tạo class
    }

    public static void start(String userId) {
        USER_ID.set(userId);
    }

    public static String getUserId() {
        return USER_ID.get();
    }

    public static void clear() {
        USER_ID.remove();
    }
}
