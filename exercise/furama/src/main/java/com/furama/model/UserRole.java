package com.furama.model;

import javax.persistence.*;

@Entity
public class UserRole {
    @EmbeddedId
    private UserRoleKey userRoleId;

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
}
