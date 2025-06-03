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
    public CommonResponse<?> createAccount(@Valid @RequestBody CreateAccountRequest createAccountRequest) throws Exception {
        accountsService.createAccount(createAccountRequest);
        return CommonResponse.ok();
    }

    @PostMapping("/updateAccount")
    public CommonResponse<?> updateAccount(@Valid @RequestBody UpdateAccountRequest updateAccountRequest) throws Exception {
        accountsService.changeStatusOfAccount(updateAccountRequest);
        return CommonResponse.ok();
    }

    @GetMapping("/queryAccount")
    public CommonResponse<AccountCardsResponse> queryAccount(@RequestParam String email, int pageNumber, int pageSize) {
        AccountCardsResponse accountCardsResponse = accountsService.queryAccountCards(email, pageNumber, pageSize);
        return CommonResponse.ok(accountCardsResponse);
    }
}
