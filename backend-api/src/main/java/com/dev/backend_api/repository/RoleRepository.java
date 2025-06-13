package com.dev.backend_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dev.backend_api.entity.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, String>, CustomIdSupportRepository {

    @Query(value = "SELECT id FROM roles WHERE id LIKE CONCAT(:prefix, '%') ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String findLastIdStartingWith(@Param("prefix") String prefix);

    // findByName
    Optional<RoleEntity> findByNameIgnoreCase(String name);
}
