package ru.tsyrikov.betoola.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tsyrikov.betoola.controller.dto.TotalAmountDto;
import ru.tsyrikov.betoola.service.GbpEuroMoneyExchangeService;

@RestController
public class GbpEuroMoneyExchangeController {

    private final GbpEuroMoneyExchangeService gbpEuroMoneyExchangeService;

    public GbpEuroMoneyExchangeController(GbpEuroMoneyExchangeService gbpEuroMoneyExchangeService) {
        this.gbpEuroMoneyExchangeService = gbpEuroMoneyExchangeService;
    }

    @PostMapping("/buy-100-gbp/calculate")
    public ResponseEntity<TotalAmountDto> getTotalEuroToPay() {
        var totalEuro = gbpEuroMoneyExchangeService.calculateEuroToPayFor100Gbp();
        return ResponseEntity.ok(new TotalAmountDto(totalEuro));
    }

    @PostMapping("/sell-100-euro/calculate")
    public ResponseEntity<TotalAmountDto> getTotalGbpToGive() {
        var totalGbp = gbpEuroMoneyExchangeService.calculateGbpToGiveFor100Euro();
        return ResponseEntity.ok(new TotalAmountDto(totalGbp));
    }
}
