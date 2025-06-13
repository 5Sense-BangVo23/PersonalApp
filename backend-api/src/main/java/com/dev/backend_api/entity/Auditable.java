package com.dev.backend_api.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.dev.backend_api.domain.RequestContext;
import com.dev.backend_api.entity.exception.ApiException;
import com.dev.backend_api.listeners.CustomIdEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(CustomIdEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public abstract class Auditable implements Identifiable {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(optional = true)
    @JoinColumn(
        name = "owner_id",
        referencedColumnName = "id",
        nullable = true,
        foreignKey = @ForeignKey(name = "fk_auditable_owner_id", value = ConstraintMode.CONSTRAINT)
    )
    private UserEntity owner;




    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    // ✅ Hoàn chỉnh setter bị thiếu
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void beforePersist() {
        String userId = RequestContext.getUserId();
        if (userId == null) {
            throw new ApiException("User ID is not set in the request context");
        }
        setCreatedAt(LocalDateTime.now());
        setCreatedBy(userId);
        setUpdatedAt(LocalDateTime.now());
        setUpdatedBy(userId);
    }

    public void beforeUpdate() {
        String userId = RequestContext.getUserId();
        if (userId == null) {
            throw new ApiException("User ID is not set in the request context");
        }
        setUpdatedAt(LocalDateTime.now());
        setUpdatedBy(userId);
    }

    public abstract String getIdPrefix();
}
