package org.example.bookkeepio.accountplan;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AccountPlanResponse {
    private final String id;
    private final Date created;
    private final Date modified;
    private final String companyId;
    private final String code;
    private final String name;
    private final AccountPlan.AccountType type;
    private final String parentAccountId;

    public static AccountPlanResponse toResponse(AccountPlanDto dto) {
        return AccountPlanResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .companyId(dto.getCompanyId())
                .code(dto.getCode())
                .name(dto.getName())
                .type(dto.getType())
                .parentAccountId(dto.getParentAccountId())
                .build();
    }
}
