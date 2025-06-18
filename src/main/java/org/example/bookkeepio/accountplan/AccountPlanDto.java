package org.example.bookkeepio.accountplan;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AccountPlanDto {
    private final String id;
    private final Date created;
    private final Date modified;
    private final String companyId;
    private final String code;
    private final String name;
    private final AccountPlan.AccountType type;
    private final String parentAccountId;
}
