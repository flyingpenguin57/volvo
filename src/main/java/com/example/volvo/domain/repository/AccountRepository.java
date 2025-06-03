package com.example.volvo.domain.repository;

import com.example.volvo.domain.model.Account;
import com.example.volvo.infrastructure.persistence.mapper.AccountMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class AccountRepository {
    @Resource
    private AccountMapper accountMapper;

    public Account getAccountByEmail(String email) {
        return accountMapper.selectByEmail(email);
    }

    public void createAccount(Account account) {
        accountMapper.insert(account);
    }

    public void updateAccountStatus(String email, int status) {
        Account account = new Account();
        account.setEmail(email);
        account.setActive(status);
        accountMapper.update(account);
    }
}
