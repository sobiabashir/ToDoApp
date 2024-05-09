package com.test;
import Sequencer.AppUserSequencer;

import java.util.Objects;

public class AppUser {
    // Fields
    private int id;
    private String username;
    private String password;
    private AppRole role;

    // Constructor
    public AppUser(String username, String password, AppRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
       this.id= AppUserSequencer.nextId();
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = getId();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username != null && !username.isEmpty()) {
            this.username = username;
        } else {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null && !password.isEmpty()) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
    }

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        if (role != null) {
            this.role = role;
        } else {
            throw new IllegalArgumentException("Role cannot be null");
        }
    }

    @Override
    public String toString() {
        return "AppUser{" + username + "  Role : " + role    + "}";
    }

    // Override hashCode() method
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    // Override equals() method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AppUser other = (AppUser) obj;
        return username.equals(other.username) && role == other.role;
    }
}
