package com.furama.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    @Column(name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "role")
    private Set<UserRole> userRoleSet;

    public Role() {
    }

    public Role(int roleId, String roleName, Set<UserRole> userRoleSet) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.userRoleSet = userRoleSet;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<UserRole> getUserRoleSet() {
        return userRoleSet;
    }

    public void setUserRoleSet(Set<UserRole> userRoleSet) {
        this.userRoleSet = userRoleSet;
    }
}
