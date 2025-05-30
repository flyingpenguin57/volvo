package com.example.volvo.controller;

import com.example.volvo.controller.request.CreateAccountRequest;
import com.example.volvo.controller.request.UpdateAccountRequest;
import com.example.volvo.controller.response.AccountCardsResponse;
import com.example.volvo.controller.response.CommonResponse;
import com.example.volvo.service.AccountsService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountsController {
    @Resource
    private AccountsService accountsService;

    @PostMapping("/createAccount")
    public CommonResponse<?> createAccount(@Valid @RequestBody CreateAccountRequest createAccountRequest) {
        accountsService.createAccount(createAccountRequest.getEmail(), createAccountRequest.getUsername());
        return CommonResponse.ok();
    }

    @PostMapping("/updateAccount")
    public CommonResponse<?> updateAccount(@Valid @RequestBody UpdateAccountRequest updateAccountRequest) {
        accountsService.updateAccount(updateAccountRequest.getEmail(), updateAccountRequest.getStatus());
        return CommonResponse.ok();

    }

    @GetMapping("/queryAccount")
    public CommonResponse<AccountCardsResponse> queryAccount(@RequestParam String email) {
        AccountCardsResponse accountCardsResponse = accountsService.queryAccountCards(email);
        return CommonResponse.ok(accountCardsResponse);
    }
}
