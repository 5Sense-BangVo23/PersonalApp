package com.dev.backend_api.listeners;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend_api.repository.CustomIdSupportRepository;

public class CustomIdGenerator {

    private static Map<Class<?>, JpaRepository<?, String>> repoMap = new HashMap<>();

    public static void registerRepo(Class<?> clazz, JpaRepository<?, String> repo) {
        repoMap.put(clazz, repo);
    }

    public static String getLastId(Class<?> clazz, String prefix) {
        JpaRepository<?, String> repo = repoMap.get(clazz);
        if (repo == null) return null;

        if (repo instanceof CustomIdSupportRepository customRepo) {
            return customRepo.findLastIdStartingWith(prefix);
        }

        return null;
    }
}
