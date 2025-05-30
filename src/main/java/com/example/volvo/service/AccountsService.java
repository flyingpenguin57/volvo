package com.example.volvo.service;

import com.example.volvo.controller.response.AccountCardsResponse;
import com.example.volvo.repository.entities.Account;
import com.example.volvo.repository.entities.Card;
import com.example.volvo.repository.mapper.AccountMapper;
import com.example.volvo.repository.mapper.CardMapper;
import com.example.volvo.utils.HashUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountsService {
    @Resource
    private AccountMapper accountMapper;

    @Resource
    private CardMapper cardMapper;


    public void createAccount(String email, String username) {
        Account accountDao = new Account();
        accountDao.setEmail(email);
        accountDao.setUsername(username);
        accountMapper.insert(accountDao);
    }

    public void updateAccount(String email, int active) {
        Account accountDao = new Account();
        accountDao.setEmail(email);
        accountDao.setActive(active);
        accountMapper.update(accountDao);
    }

    public AccountCardsResponse queryAccountCards(String email) {
        Account account = new Account();
        account.setEmail(email);
        Account accountInfo = accountMapper.selectByEmail(account);

        Card card = new Card();
        card.setContractId(HashUtil.hashWithGuava(email));
        List<Card> cards = cardMapper.selectByContractId(card);

        AccountCardsResponse accountCardsResponse = new AccountCardsResponse();
        accountCardsResponse.setCards(cards);
        accountCardsResponse.setEmail(email);
        accountCardsResponse.setActive(accountInfo.getActive());

        return accountCardsResponse;
    }
}
