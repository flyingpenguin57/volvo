package com.example.volvo.application;

import com.example.volvo.api.request.UpdateCardRequest;
import com.example.volvo.domain.model.Account;
import com.example.volvo.domain.model.Card;
import com.example.volvo.domain.repository.CardRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CardApplication {
    @Resource
    private CardRepository cardRepository;

    public String createCard() {
        Card newCard = Card.createNewCard();
        cardRepository.insert(newCard);
        return newCard.getCardNumber();
    }

    public void assignCard(UpdateCardRequest request) {
        String contractId = Account.getContractIdFromEmail(request.getEmail());
        cardRepository.updateContractId(contractId, request.getCardNumber());
    }

    public void changeCardStatus(UpdateCardRequest request) {
        cardRepository.updateCardStatus(request.getCardNumber(), request.getActive());
    }
}
