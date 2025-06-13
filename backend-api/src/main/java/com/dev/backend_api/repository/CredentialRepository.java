package com.dev.backend_api.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dev.backend_api.entity.CredentialEntity;

@Repository
public interface CredentialRepository extends JpaRepository<CredentialEntity, String>, CustomIdSupportRepository {
    
    @Query(value = "SELECT id FROM credentials WHERE id LIKE CONCAT(:prefix, '%') ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String findLastIdStartingWith(@Param("prefix") String prefix);

    Optional<CredentialEntity> getCredentialByUserEntityId(String userId);
}
