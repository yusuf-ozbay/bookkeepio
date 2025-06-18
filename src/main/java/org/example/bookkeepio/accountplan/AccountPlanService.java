package org.example.bookkeepio.accountplan;


import java.util.List;

public interface AccountPlanService {
    AccountPlanDto create(AccountPlanDto dto);
    List<AccountPlanDto> getAll();
    AccountPlanDto update(String id, AccountPlanDto dto);
    void delete(String id);
}
