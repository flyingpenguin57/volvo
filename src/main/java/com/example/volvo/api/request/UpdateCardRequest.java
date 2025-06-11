package com.example.volvo.api.request;

import jakarta.validation.constraints.NotBlank;

public class UpdateCardRequest {
    private String email;
    @NotBlank(message = "business error-cardNumber cannot be null")
    private String cardNumber;
    private int active;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
