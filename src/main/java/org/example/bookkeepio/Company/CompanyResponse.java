package org.example.bookkeepio.Company;

import lombok.*;

import java.util.Date;

@Data
@Builder
public class CompanyResponse {
    private final String id;
    private final Date created;
    private final Date modified;
    private final String name;
    private final String taxNumber;
    private final String address;
    private final String defaultCurrencyId;
    private final Boolean multiCurrencyEnabled;
    private final Boolean multiBranchEnabled;

    public static CompanyResponse toResponse(CompanyDto dto) {
        return CompanyResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .name(dto.getName())
                .taxNumber(dto.getTaxNumber())
                .address(dto.getAddress())
                .defaultCurrencyId(dto.getDefaultCurrencyId())
                .multiCurrencyEnabled(dto.getMultiCurrencyEnabled())
                .multiBranchEnabled(dto.getMultiBranchEnabled())
                .build();
    }
}
