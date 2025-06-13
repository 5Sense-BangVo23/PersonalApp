package com.dev.backend_api.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class UserEntity extends Auditable{
    
    @Column(updatable=false, unique=true, nullable=false)
    private String userId;

    private String firstName;
    private String lastName;
    private String password;
    @Column(unique=true, nullable=false)
    private String email;
    private Integer loginAttempts;
    private LocalDateTime lastLogin;
    private String phone;
    private String bio;
    private String imageUrl;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean enabled;
    private boolean credentialsNonExpired;
    private boolean mfa;
    @JsonIgnore
    private String qrCodeSecret;
    @Column(columnDefinition = "TEXT")
    private String qrCodeImageUri;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinTable(name = "user_roles",
                joinColumns = @jakarta.persistence.JoinColumn(name = "user_id", referencedColumnName = "id"),
                inverseJoinColumns = @jakarta.persistence.JoinColumn(name = "role_id", referencedColumnName = "id"))
    private RoleEntity role;

    @Override
    public String getIdPrefix() {
        return "USER";
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setQrCodeSecret(String qrCodeSecret) {
        this.qrCodeSecret = qrCodeSecret;
    }

    public String getBio() {
        return bio;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public String getQrCodeSecret() {
        return qrCodeSecret;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Integer getLoginAttempts() {
        return loginAttempts;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public String getPhone() {
        return phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }


    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public boolean isMfa() {
        return mfa;
    }

   

    public String getQrCodeImageUri() {
        return qrCodeImageUri;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLoginAttempts(Integer loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setMfa(boolean mfa) {
        this.mfa = mfa;
    }

   

    public void setQrCodeImageUri(String qrCodeImageUri) {
        this.qrCodeImageUri = qrCodeImageUri;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }


    
    
}
