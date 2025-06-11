package com.example.volvo.api;

import com.example.volvo.api.request.UpdateCardRequest;
import com.example.volvo.api.response.CreateCardResponse;
import com.example.volvo.application.CardApplication;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardsInterface {
    @Resource
    private CardApplication cardApplication;

    @PostMapping("/createCard")
    public ResponseEntity<CreateCardResponse> createAccount() {
        String cardNumber = cardApplication.createCard();
        return ResponseEntity.ok(new CreateCardResponse(cardNumber));
    }

    @PostMapping("/assignCard")
    public ResponseEntity<?> updateAccount(@Valid @RequestBody UpdateCardRequest updateCardRequest) {
        cardApplication.assignCard(updateCardRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/changeCardStatus")
    public ResponseEntity<?> changeCardStatus(@Valid @RequestBody UpdateCardRequest updateCardRequest) {
        cardApplication.changeCardStatus(updateCardRequest);
        return ResponseEntity.ok().build();
    }
}
