package com.example.volvo.controller.response;

import com.example.volvo.domain.model.Card;

import java.util.List;

public class AccountCardsResponse {
    private String email;
    private int active;
    private List<Card> cards;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public AccountCardsResponse(String email, int active, List<Card> cards) {
        this.email = email;
        this.active = active;
        this.cards = cards;
    }
}
