package ru.tsyrikov.betoola.config;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.tsyrikov.betoola.rounding.FairRoundingStrategy;
import ru.tsyrikov.betoola.rounding.RoundingStrategyMode;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplicationConfigurationProperties {

    RoundingStrategyMode roundingStrategy = RoundingStrategyMode.FAIR;
    BigDecimal convertMarginPercent;
    Currencies currencies = new Currencies();

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Currencies {
        private BigDecimal gbpEuro;
    }

}
