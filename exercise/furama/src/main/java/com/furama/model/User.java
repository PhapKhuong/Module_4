package com.furama.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class User {
    @Id
    private String username;

    private String password;

    @OneToMany(mappedBy = "user ")
    private Set<Employee> employeeSet;

    public User() {
    }

    public User(String username, String password, Set<Employee> employeeSet) {
        this.username = username;
        this.password = password;
        this.employeeSet = employeeSet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}
