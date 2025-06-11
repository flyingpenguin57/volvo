package com.example.volvo.application;

import com.example.volvo.api.request.CreateAccountRequest;
import com.example.volvo.domain.model.Account;
import com.example.volvo.domain.repository.AccountRepository;
import com.example.volvo.exceptions.BizException;
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
public class AccountsApplicationTest {

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
            assertInstanceOf(BizException.class, e);
            assertEquals(((BizException) e).getBizError().getErrorMessage(), "email already exits!");
        }
        assertTrue(exception);
    }
}
