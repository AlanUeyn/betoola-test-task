package ru.tsyrikov.betoola.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.tsyrikov.betoola.rounding.CustomerFavorRoundingStrategy;
import ru.tsyrikov.betoola.rounding.FairRoundingStrategy;
import ru.tsyrikov.betoola.rounding.ServiceFavorRoundingStrategy;

import java.math.BigDecimal;

public class CurrencyConverterTest {

    @Test
    public void convert() {
        CurrencyConverter currencyConverter =
                new CurrencyConverter(new BigDecimal("1.2375"), new FairRoundingStrategy());
        var amountToConvert = new BigDecimal("100.00");
        Assertions.assertEquals(
                0,
                new BigDecimal("123.75").compareTo(currencyConverter.convert(amountToConvert))
        );
    }

    @Test
    public void reverseConvertWithFairStrategy() {
        CurrencyConverter currencyConverter =
                new CurrencyConverter(new BigDecimal("1.2375"), new FairRoundingStrategy());
        var amountToConvert = new BigDecimal("100.00");
        Assertions.assertEquals(
                0,
                new BigDecimal("80.81").compareTo(currencyConverter.reverseConvert(amountToConvert))
        );
    }

    @Test
    public void reverseConvertWithCustomerFavorStrategy() {
        CurrencyConverter currencyConverter =
                new CurrencyConverter(new BigDecimal("1.2375"), new CustomerFavorRoundingStrategy());
        var amountToConvert = new BigDecimal("100.00");
        Assertions.assertEquals(
                0,
                new BigDecimal("80.81").compareTo(currencyConverter.reverseConvert(amountToConvert))
        );
    }

    @Test
    public void reverseConvertWithServiceFavorStrategy() {
        CurrencyConverter currencyConverter =
                new CurrencyConverter(new BigDecimal("1.2375"), new ServiceFavorRoundingStrategy());
        var amountToConvert = new BigDecimal("100.00");
        Assertions.assertEquals(
                0,
                new BigDecimal("80.80").compareTo(currencyConverter.reverseConvert(amountToConvert))
        );
    }
}
