package com.blog_security.model.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class AppRole {
    @Id
    private int roleId;
    @Column(name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "role")
    private Set<UserRole> userRoleSet;

    public AppRole() {
    }

    public AppRole(int roleId, String roleName, Set<UserRole> userRoleSet) {
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
