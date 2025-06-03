package com.example.volvo.controller.response;

public class CreateCardResponse {
    private String cardNumber;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public CreateCardResponse(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
