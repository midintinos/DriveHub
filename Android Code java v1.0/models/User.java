package com.drivehub.models;

public class User {
    protected String userID;
    protected String name;
    protected String email;
    protected String password;

    public boolean login(String inputEmail, String inputPassword) {
        return this.email.equals(inputEmail) && this.password.equals(inputPassword);
    }

    private boolean isBanned = false;

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        this.isBanned = banned;
    }


    public void logout() {
        // clear session/token
    }

    public void updateProfile(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}