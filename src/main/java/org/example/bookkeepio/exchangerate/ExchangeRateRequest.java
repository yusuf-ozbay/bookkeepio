package org.example.bookkeepio.exchangerate;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class ExchangeRateRequest {
    private final String currencyId;
    private final LocalDate date;
    private final BigDecimal rateToBaseCurrency;

    public ExchangeRateDto toDto() {
        return ExchangeRateDto.builder()
                .currencyId(currencyId)
                .date(date)
                .rateToBaseCurrency(rateToBaseCurrency)
                .build();
    }
}
