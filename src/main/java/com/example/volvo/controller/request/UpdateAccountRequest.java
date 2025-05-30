package com.example.volvo.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class UpdateAccountRequest {
    @Email
    private String email;
    @NotNull
    private int status;

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public @NotNull int getStatus() {
        return status;
    }

    public void setStatus(@NotNull int status) {
        this.status = status;
    }
}
