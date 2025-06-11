package com.example.volvo.service;

import com.example.volvo.api.request.CreateAccountRequest;
import com.example.volvo.application.AccountsApplication;
import com.example.volvo.domain.model.Account;
import com.example.volvo.domain.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AccountsServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountsApplication accountsService;

    @Test
    public void testCreateNewAccount() throws Exception {
        Mockito.when(accountRepository.getAccountByEmail(Mockito.anyString())).thenReturn(null);
        Mockito.doNothing().when(accountRepository).createAccount(Mockito.any());

        CreateAccountRequest createAccountRequest = new CreateAccountRequest();
        createAccountRequest.setEmail("123@gg.com");
        createAccountRequest.setUsername("xial");
        accountsService.createAccount(createAccountRequest);
    }

    @Test
    public void testCreateNewAccountFail() throws Exception {
        boolean exception = false;
        Mockito.when(accountRepository.getAccountByEmail(Mockito.anyString())).thenReturn(new Account());
        CreateAccountRequest createAccountRequest = new CreateAccountRequest();
        createAccountRequest.setEmail("123@gg.com");
        createAccountRequest.setUsername("xialo");
        try {
            accountsService.createAccount(createAccountRequest);
        } catch (Exception e) {
            exception = true;
            assertNotNull(e);
            assertEquals(e.getMessage(), "email already exits!");
        }
        assertTrue(exception);
    }
}
