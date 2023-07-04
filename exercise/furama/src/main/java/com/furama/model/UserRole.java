package com.furama.model;

import com.furama.model.key.KeyUserRole;

import javax.persistence.*;

@Entity
public class UserRole {
    @EmbeddedId
    private KeyUserRole userRoleId;

    @ManyToOne
    @MapsId("username")
    @JoinColumn(name = "username")
    private User user;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private Role role;

    public UserRole() {
    }

    public UserRole(KeyUserRole userRoleId, User user, Role role) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
