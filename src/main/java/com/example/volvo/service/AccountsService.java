package com.example.volvo.service;

import com.example.volvo.controller.request.CreateAccountRequest;
import com.example.volvo.controller.request.UpdateAccountRequest;
import com.example.volvo.controller.response.AccountCardsResponse;
import com.example.volvo.domain.model.Account;
import com.example.volvo.domain.model.Card;
import com.example.volvo.domain.repository.AccountRepository;
import com.example.volvo.domain.repository.CardRepository;
import com.example.volvo.exceptions.BusinessException;
import com.example.volvo.utils.AssertUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountsService {
    @Resource
    private AccountRepository accountRepository;
    @Resource
    private CardRepository cardRepository;

    public void createAccount(CreateAccountRequest request) throws Exception {
        Account accountByEmail = accountRepository.getAccountByEmail(request.getEmail());
        AssertUtil.isNull(accountByEmail, BusinessException.AccountEmailExist);
        Account account = Account.createNewAccount(request.getEmail(), request.getUsername());
        accountRepository.createAccount(account);
    }

    public void changeStatusOfAccount(UpdateAccountRequest request) throws Exception {
        Account accountByEmail = accountRepository.getAccountByEmail(request.getEmail());
        AssertUtil.notNull(accountByEmail, BusinessException.EmailNotExist);
        accountRepository.updateAccountStatus(request.getEmail(), request.getStatus());
    }

    public AccountCardsResponse queryAccountCards(String email, int pageNumber, int pageSize) {
        Account accountByEmail = accountRepository.getAccountByEmail(email);
        AssertUtil.notNull(accountByEmail, BusinessException.EmailNotExist);
        List<Card> cardsByEmail = cardRepository.getCardsByEmail(email, pageNumber * pageSize, pageSize);
        return new AccountCardsResponse(accountByEmail.getEmail(), accountByEmail.getActive(), cardsByEmail);
    }
}
