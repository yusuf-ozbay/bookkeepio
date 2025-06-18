package org.example.bookkeepio.accountplan;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountPlanRepository extends JpaRepository<AccountPlan, String> {
    Optional<AccountPlan> findByCodeAndCompany_Id(String code, String companyId);
}
