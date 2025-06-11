package com.example.volvo.api.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class UpdateAccountRequest {
    @Email(message = "business error-email incorrect")
    private String email;
    @NotNull(message = "business error-status cannot be null")
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
