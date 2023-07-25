package com.blog_security.model.account;

public class AppUserDto {
    private String username;
    private String password;

    public AppUserDto() {
    }

    public AppUserDto(String username, String password) {
        this.username = username;
        this.password = password;
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
}
