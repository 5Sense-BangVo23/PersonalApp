package com.dev.backend_api.repository;

public interface CustomIdSupportRepository {
    String findLastIdStartingWith(String prefix);
}

