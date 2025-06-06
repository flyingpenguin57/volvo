package com.example.volvo.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CreateAccountRequest {
    @Email(message = "business error-email incorrect")
    private String email;
    @NotBlank(message = "business error-username cannot be null")
    private String username;

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public @NotBlank String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank String username) {
        this.username = username;
    }
}
