package com.dev.backend_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dev.backend_api.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>, CustomIdSupportRepository {

    @Query(value = "SELECT id FROM users WHERE id LIKE CONCAT(:prefix, '%') ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String findLastIdStartingWith(@Param("prefix") String prefix);
}

