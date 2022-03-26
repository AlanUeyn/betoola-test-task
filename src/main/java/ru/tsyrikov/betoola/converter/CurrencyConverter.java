package ru.tsyrikov.betoola.converter;

import org.springframework.lang.NonNull;
import org.springframework.util.Assert;
import ru.tsyrikov.betoola.rounding.RoundingStrategy;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

public class CurrencyConverter {

    private final AtomicReference<BigDecimal> currencyRate = new AtomicReference<>();
    private final RoundingStrategy roundingStrategy;

    public CurrencyConverter(BigDecimal currencyRate, RoundingStrategy roundingStrategy) {
        Assert.notNull(currencyRate, "The currency rate can't be null!");
        this.currencyRate.set(currencyRate);
        this.roundingStrategy = roundingStrategy;
    }

    public BigDecimal convert(@NonNull BigDecimal amount) {
        var currency = currencyRate.get();
        return amount.multiply(currency);
    }


    public BigDecimal reverseConvert(@NonNull BigDecimal amount) {
         var currency = BigDecimal.ONE.setScale(4, roundingStrategy.buyRounding())
                 .divide(currencyRate.get(), roundingStrategy.buyRounding());
         return amount.multiply(currency);
    }


    public void setCurrencyRate(BigDecimal currencyRate) {
        this.currencyRate.set(currencyRate);
    }
}
