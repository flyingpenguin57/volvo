package com.example.volvo.domain.model;

public class Card {
    private long id;
    private String contractId;
    private String cardNumber;
    private int active;

    public static Card createNewCard() {
        Card card = new Card();
        String cardNumber = String.valueOf(System.currentTimeMillis());
        card.setCardNumber(cardNumber);
        return card;
    }

    public Card() {}

    public Card(long id, String contractId, String cardNumber, int active) {
        this.id = id;
        this.contractId = contractId;
        this.cardNumber = cardNumber;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
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
