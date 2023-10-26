package com.system.authentication;

public class AdminImp implements Admin {
    private String username;
    private String password;

    public AdminImp(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}
