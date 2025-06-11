package com.example.volvo.api;

import com.example.volvo.api.request.CreateAccountRequest;
import com.example.volvo.api.request.UpdateAccountRequest;
import com.example.volvo.api.response.AccountCardsResponse;
import com.example.volvo.application.AccountsApplication;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountsInterface {
    @Resource
    private AccountsApplication accountsApplication;

    @PostMapping("/createAccount")
    public ResponseEntity<?> createAccount(@Valid @RequestBody CreateAccountRequest createAccountRequest) throws Exception {
        accountsApplication.createAccount(createAccountRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/updateAccount")
    public ResponseEntity<?> updateAccount(@Valid @RequestBody UpdateAccountRequest updateAccountRequest) throws Exception {
        accountsApplication.changeStatusOfAccount(updateAccountRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/queryAccount")
    public ResponseEntity<AccountCardsResponse> queryAccount(@RequestParam String email, int pageNumber, int pageSize) {
        AccountCardsResponse accountCardsResponse = accountsApplication.queryAccountCards(email, pageNumber, pageSize);
        return ResponseEntity.ok(accountCardsResponse);
    }
}
