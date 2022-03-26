package ru.tsyrikov.betoola.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tsyrikov.betoola.converter.CurrencyConverter;
import ru.tsyrikov.betoola.rounding.*;
import ru.tsyrikov.betoola.service.GbpEuroMoneyExchangeService;

import java.math.BigDecimal;

@Configuration
public class ApplicationConfiguration {

    @Bean
    @ConfigurationProperties("app")
    public ApplicationConfigurationProperties applicationConfigurationProperties() {
        return new ApplicationConfigurationProperties();
    }

    @Bean
    public CurrencyConverter gbpToEuroCurrencyConverter(ApplicationConfigurationProperties properties) {
        return new CurrencyConverter(
                properties.getCurrencies().getGbpEuro(),
                resolveRoundingStrategy(properties.getRoundingStrategy())
        );
    }

    @Bean
    public GbpEuroMoneyExchangeService moneyExchangeService(ApplicationConfigurationProperties properties,
                                                            CurrencyConverter gbpToEuroCurrencyConverter
    ) {
        return new GbpEuroMoneyExchangeService(
                gbpToEuroCurrencyConverter,
                resolveRoundingStrategy(properties.getRoundingStrategy()),
                properties.getConvertMarginPercent()
        );
    }

    private RoundingStrategy resolveRoundingStrategy(RoundingStrategyMode strategyMode) {
        return switch (strategyMode) {
            case FAIR -> new FairRoundingStrategy();
            case CUSTOMER_FAVOR -> new CustomerFavorRoundingStrategy();
            case SERVICE_FAVOR -> new ServiceFavorRoundingStrategy();
        };
    }
}
