package com.account.model;

import com.account.model.key.KeyUserRole;

import javax.persistence.*;

@Entity
public class UserRole {
    @EmbeddedId
    private KeyUserRole userRoleId;

    @ManyToOne
    @MapsId("username")
    @JoinColumn(name = "username")
    private AppUser user;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private AppRole role;

    public UserRole() {
    }

    public UserRole(KeyUserRole userRoleId, AppUser user, AppRole role) {
        this.userRoleId = userRoleId;
        this.user = user;
        this.role = role;
    }

    public KeyUserRole getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(KeyUserRole userRoleId) {
        this.userRoleId = userRoleId;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        this.role = role;
    }
}
