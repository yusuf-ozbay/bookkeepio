package org.example.bookkeepio.Company;

import lombok.*;

import java.util.Date;

@Data
@Builder
public class CompanyDto {
    private final String id;
    private final Date created;
    private final Date modified;
    private final String name;
    private final String taxNumber;
    private final String address;
    private final String defaultCurrencyId;
    private final Boolean multiCurrencyEnabled;
    private final Boolean multiBranchEnabled;
}
