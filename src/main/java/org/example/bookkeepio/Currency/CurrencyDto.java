package org.example.bookkeepio.Currency;

import lombok.*;

import java.util.Date;

@Data
@Builder
public class CurrencyDto {
    private final String id;
    private final Date created;
    private final Date modified;
    private final String code;
    private final String name;
}
