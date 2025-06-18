package org.example.bookkeepio.Company;

import lombok.*;
import org.example.bookkeepio.Company.CompanyDto;

@Data
@Builder
public class CompanyRequest {
    private final String name;
    private final String taxNumber;
    private final String address;
    private final String defaultCurrencyId;
    private final Boolean multiCurrencyEnabled;
    private final Boolean multiBranchEnabled;

    public CompanyDto toDto() {
        return CompanyDto.builder()
                .name(name)
                .taxNumber(taxNumber)
                .address(address)
                .defaultCurrencyId(defaultCurrencyId)
                .multiCurrencyEnabled(multiCurrencyEnabled)
                .multiBranchEnabled(multiBranchEnabled)
                .build();
    }
}
