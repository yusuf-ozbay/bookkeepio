package org.example.bookkeepio.Currency;

import lombok.*;

import java.util.Date;

@Data
@Builder
public class CurrencyResponse {
    private final String id;
    private final Date created;
    private final Date modified;
    private final String code;
    private final String name;

    public static CurrencyResponse toResponse(CurrencyDto dto) {
        return CurrencyResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .code(dto.getCode())
                .name(dto.getName())
                .build();
    }
}
