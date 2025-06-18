package org.example.bookkeepio.exchangerate;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
public class ExchangeRateDto {
    private final String id;
    private final Date created;
    private final Date modified;
    private final String currencyId;
    private final LocalDate date;
    private final BigDecimal rateToBaseCurrency;
}
