package org.example.bookkeepio.accountplan;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountPlanRequest {
    private final String companyId;
    private final String code;
    private final String name;
    private final AccountPlan.AccountType type;
    private final String parentAccountId;

    public AccountPlanDto toDto() {
        return AccountPlanDto.builder()
                .companyId(companyId)
                .code(code)
                .name(name)
                .type(type)
                .parentAccountId(parentAccountId)
                .build();
    }
}
