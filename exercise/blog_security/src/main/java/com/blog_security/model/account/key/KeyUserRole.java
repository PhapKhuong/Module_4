package com.blog_security.model.account.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class KeyUserRole implements Serializable {
    private String username;
    @Column(name = "role_id")
    private int roleId;

    public KeyUserRole() {
    }

    public KeyUserRole(String username, int roleId) {
        this.username = username;
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
