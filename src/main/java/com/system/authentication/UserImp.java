package com.system.authentication;

public class UserImp implements User {
    private String username;
    private String password;

    public UserImp(String username, String password) {
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
