package com.example.volvo.service;

import com.example.volvo.repository.entities.Card;
import com.example.volvo.repository.mapper.CardMapper;
import com.example.volvo.utils.HashUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Resource
    private CardMapper cardMapper;

    public String createCard() {
        Card card = new Card();
        String cardNumber = String.valueOf(System.currentTimeMillis());
        card.setCardNumber(cardNumber);
        cardMapper.insert(card);
        return cardNumber;
    }

    public void assignCard(String cardNumber, String email) {
        Card card = new Card();
        card.setCardNumber(cardNumber);
        card.setContractId(HashUtil.hashWithGuava(email));
        cardMapper.updateContractId(card);
    }

    public void changeCardStatus(String cardNumber, int active) {
        Card card = new Card();
        card.setCardNumber(cardNumber);
        card.setActive(active);
        cardMapper.updateStatus(card);
    }

    public List<Card> getCardsByAccount(String email) {
        Card card = new Card();
        card.setContractId(HashUtil.hashWithGuava(email));
        return cardMapper.selectByContractId(card);
    }
}
