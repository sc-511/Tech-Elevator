package com.techelevator.tenmo.model;

import javax.validation.constraints.NotEmpty;

public class RegisterUserDTO {

    @NotEmpty (message = "The field `username` should not be blank.")
    private String username;
    @NotEmpty (message = "The field `password` should not be blank.")
    private String password;

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
