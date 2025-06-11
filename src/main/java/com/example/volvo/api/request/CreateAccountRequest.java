package com.example.volvo.api.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CreateAccountRequest {
    @Email(message = "param error: email incorrect")
    @NotBlank(message = "param error: email cannot be null")
    private String email;
    @NotBlank(message = "param error: username cannot be null")
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
