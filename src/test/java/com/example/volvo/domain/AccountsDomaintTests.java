package com.example.volvo.domain;

import com.example.volvo.domain.model.Account;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountsDomaintTests {

    @Test
    public void test1() {
        Account account = Account.createNewAccount("fdf343@tt.com", "fdjfk");
        assertNotNull(account);
    }
}
