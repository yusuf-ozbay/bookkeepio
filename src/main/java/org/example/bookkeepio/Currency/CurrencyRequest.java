package org.example.bookkeepio.Currency;

import lombok.*;

@Data
@Builder
public class CurrencyRequest {
    private final String code;
    private final String name;

    public CurrencyDto toDto() {
        return CurrencyDto.builder()
                .code(code)
                .name(name)
                .build();
    }
}
