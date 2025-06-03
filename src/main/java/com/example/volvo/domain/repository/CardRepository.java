package com.example.volvo.domain.repository;

import com.example.volvo.domain.model.Account;
import com.example.volvo.domain.model.Card;
import com.example.volvo.infrastructure.persistence.mapper.CardMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CardRepository {
    @Resource
    private CardMapper cardMapper;

    public void insert(Card newCard) {
        cardMapper.insert(newCard);
    }

    public void updateContractId(String contractId, String cardNumber) {
        Card card = new Card();
        card.setContractId(contractId);
        card.setCardNumber(cardNumber);
        cardMapper.updateContractId(card);
    }

    public void updateCardStatus(String cardNumber, int active) {
        Card card = new Card();
        card.setActive(active);
        card.setCardNumber(cardNumber);
        cardMapper.updateStatus(card);
    }

    public List<Card> getCardsByEmail(String email, int from, int size) {
        String contractId = Account.getContractIdFromEmail(email);
        return cardMapper.selectByContractId(contractId, from, size);
    }
}
