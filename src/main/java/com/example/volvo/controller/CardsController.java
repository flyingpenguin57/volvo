package com.example.volvo.controller;

import com.example.volvo.controller.request.UpdateCardRequest;
import com.example.volvo.controller.response.CommonResponse;
import com.example.volvo.controller.response.CreateCardResponse;
import com.example.volvo.service.CardService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardsController {
    @Resource
    private CardService cardService;

    @PostMapping("/createCard")
    public CommonResponse<CreateCardResponse> createAccount() {
        String cardNumber = cardService.createCard();
        return CommonResponse.ok(new CreateCardResponse(cardNumber));
    }

    @PostMapping("/assignCard")
    public CommonResponse<?> updateAccount(@Valid @RequestBody UpdateCardRequest updateCardRequest) {
        cardService.assignCard(updateCardRequest);
        return CommonResponse.ok();
    }

    @PostMapping("/changeCardStatus")
    public CommonResponse<?> changeCardStatus(@Valid @RequestBody UpdateCardRequest updateCardRequest) {
        cardService.changeCardStatus(updateCardRequest);
        return CommonResponse.ok();
    }
}
