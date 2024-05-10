package org.launchcode.models;

import org.springframework.web.bind.annotation.RequestParam;

public class User {
    private int id;
    private int nextId = 1;
    private String userName;
    private String email;
    private  String password;


    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        id = nextId;
        nextId++;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Welcome " + userName ;
    }
}
