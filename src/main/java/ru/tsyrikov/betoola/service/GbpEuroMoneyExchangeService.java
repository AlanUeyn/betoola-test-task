package ru.tsyrikov.betoola.service;

import org.springframework.util.Assert;
import ru.tsyrikov.betoola.converter.CurrencyConverter;
import ru.tsyrikov.betoola.rounding.RoundingStrategy;

import java.math.BigDecimal;

public class GbpEuroMoneyExchangeService {

    private static final BigDecimal ONE_HUNDRED = new BigDecimal("100.00");

    private final CurrencyConverter currencyConverter;

    private final RoundingStrategy roundingStrategy;

    private final BigDecimal convertMarginPercent;

    public GbpEuroMoneyExchangeService(
            CurrencyConverter currencyConverter,
            RoundingStrategy roundingStrategy,
            BigDecimal convertMarginPercent
    ) {
        Assert.notNull(convertMarginPercent, "The convert margin percent can't be null!");
        this.currencyConverter = currencyConverter;
        this.roundingStrategy = roundingStrategy;
        this.convertMarginPercent = convertMarginPercent;
    }

    public BigDecimal calculateEuroToPayFor100Gbp() {
        return currencyConverter.convert(ONE_HUNDRED)
                .multiply(BigDecimal.ONE.add(convertMarginPercent))
                .setScale(2, roundingStrategy.sellRounding());
    }

    public BigDecimal calculateGbpToGiveFor100Euro() {
        return currencyConverter.reverseConvert(ONE_HUNDRED)
                .multiply(BigDecimal.ONE.subtract(convertMarginPercent))
                .setScale(2, roundingStrategy.buyRounding());
    }
}
