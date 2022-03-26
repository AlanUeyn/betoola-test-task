package ru.tsyrikov.betoola.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.tsyrikov.betoola.converter.CurrencyConverter;
import ru.tsyrikov.betoola.rounding.CustomerFavorRoundingStrategy;
import ru.tsyrikov.betoola.rounding.FairRoundingStrategy;
import ru.tsyrikov.betoola.rounding.ServiceFavorRoundingStrategy;

import java.math.BigDecimal;

public class GbpEuroMoneyExchangeServiceTest {

    @Test
    public void calculateEuroToPayFor100GbpWithFairRoundingMode() {
        var roundingStrategy = new FairRoundingStrategy();
        CurrencyConverter currencyConverter = new CurrencyConverter(
                new BigDecimal("1.2375"),
                roundingStrategy
        );
        GbpEuroMoneyExchangeService moneyExchangeService = new GbpEuroMoneyExchangeService(
                currencyConverter,
                roundingStrategy,
                new BigDecimal("0.02")
        );
        Assertions.assertEquals(new BigDecimal("126.23"), moneyExchangeService.calculateEuroToPayFor100Gbp());

    }

    @Test
    public void calculateEuroToPayFor100GbpWithCustomerRoundingMode() {
        var roundingStrategy = new CustomerFavorRoundingStrategy();
        CurrencyConverter currencyConverter = new CurrencyConverter(
                new BigDecimal("1.2375"),
                roundingStrategy
        );
        GbpEuroMoneyExchangeService moneyExchangeService = new GbpEuroMoneyExchangeService(
                currencyConverter,
                roundingStrategy,
                new BigDecimal("0.02")
        );
        Assertions.assertEquals(new BigDecimal("126.22"), moneyExchangeService.calculateEuroToPayFor100Gbp());
    }

    @Test
    public void calculateEuroToPayFor100GbpWithServiceRoundingMode() {
        var roundingStrategy = new ServiceFavorRoundingStrategy();
        CurrencyConverter currencyConverter = new CurrencyConverter(
                new BigDecimal("1.2375"),
                roundingStrategy
        );
        GbpEuroMoneyExchangeService moneyExchangeService = new GbpEuroMoneyExchangeService(
                currencyConverter,
                roundingStrategy,
                new BigDecimal("0.02")
        );
        Assertions.assertEquals(new BigDecimal("126.23"), moneyExchangeService.calculateEuroToPayFor100Gbp());
    }

    @Test
    public void calculateGbpToGiveFor100EuroWithFairRoundingMode() {
        var roundingStrategy = new FairRoundingStrategy();
        CurrencyConverter currencyConverter = new CurrencyConverter(
                new BigDecimal("1.2375"),
                roundingStrategy
        );
        GbpEuroMoneyExchangeService moneyExchangeService = new GbpEuroMoneyExchangeService(
                currencyConverter,
                roundingStrategy,
                new BigDecimal("0.02")
        );
        Assertions.assertEquals(new BigDecimal("79.19"), moneyExchangeService.calculateGbpToGiveFor100Euro());
    }

    @Test
    public void calculateGbpToGiveFor100EuroWithCustomerRoundingMode() {
        var roundingStrategy = new CustomerFavorRoundingStrategy();
        CurrencyConverter currencyConverter = new CurrencyConverter(
                new BigDecimal("1.2375"),
                roundingStrategy
        );
        GbpEuroMoneyExchangeService moneyExchangeService = new GbpEuroMoneyExchangeService(
                currencyConverter,
                roundingStrategy,
                new BigDecimal("0.02")
        );
        Assertions.assertEquals(new BigDecimal("79.20"), moneyExchangeService.calculateGbpToGiveFor100Euro());
    }

    @Test
    public void calculateGbpToGiveFor100EuroWithServiceRoundingMode() {
        var roundingStrategy = new ServiceFavorRoundingStrategy();
        CurrencyConverter currencyConverter = new CurrencyConverter(
                new BigDecimal("1.2375"),
                roundingStrategy
        );
        GbpEuroMoneyExchangeService moneyExchangeService = new GbpEuroMoneyExchangeService(
                currencyConverter,
                roundingStrategy,
                new BigDecimal("0.02")
        );
        Assertions.assertEquals(new BigDecimal("79.18"), moneyExchangeService.calculateGbpToGiveFor100Euro());
    }


}
