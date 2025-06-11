package com.example.volvo.application;

import com.example.volvo.api.request.UpdateCardRequest;
import com.example.volvo.domain.model.Account;
import com.example.volvo.domain.model.Card;
import com.example.volvo.domain.repository.AccountRepository;
import com.example.volvo.domain.repository.CardRepository;
import com.example.volvo.exceptions.BizError;
import com.example.volvo.utils.AssertUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CardApplication {
    @Resource
    private CardRepository cardRepository;

    @Resource
    private AccountRepository accountRepository;

    public String createCard() {
        Card newCard = Card.createNewCard();
        cardRepository.insert(newCard);
        return newCard.getCardNumber();
    }

    public void assignCard(UpdateCardRequest request) {
        Account accountByEmail = accountRepository.getAccountByEmail(request.getEmail());
        AssertUtil.notNull(accountByEmail, BizError.EmailNotExist);

        Card cardByCardNumber = cardRepository.getCardByCardNumber(request.getCardNumber());
        AssertUtil.notNull(cardByCardNumber, BizError.CardNotExist);

        String contractId = Account.getContractIdFromEmail(request.getEmail());
        cardRepository.updateContractId(contractId, request.getCardNumber());
    }

    public void changeCardStatus(UpdateCardRequest request) {
        Card cardByCardNumber = cardRepository.getCardByCardNumber(request.getCardNumber());
        AssertUtil.notNull(cardByCardNumber, BizError.CardNotExist);

        cardRepository.updateCardStatus(request.getCardNumber(), request.getActive());
    }
}
