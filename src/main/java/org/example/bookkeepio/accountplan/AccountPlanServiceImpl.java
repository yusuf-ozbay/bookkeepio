package org.example.bookkeepio.accountplan;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.example.bookkeepio.Company.Company;
import org.example.bookkeepio.Company.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountPlanServiceImpl implements AccountPlanService {

    private final AccountPlanRepository repository;
    private final CompanyRepository companyRepository;

    @Override
    public AccountPlanDto create(AccountPlanDto dto) {
        repository.findByCodeAndCompany_Id(dto.getCode(), dto.getCompanyId())
                .ifPresent(a -> { throw new EntityExistsException("Account already exists"); });

        return toDto(repository.save(toEntity(dto)));
    }

    @Override
    public List<AccountPlanDto> getAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public AccountPlanDto update(String id, AccountPlanDto dto) {
        AccountPlan account = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        account.setCode(dto.getCode());
        account.setName(dto.getName());
        account.setType(dto.getType());

        if (dto.getParentAccountId() != null) {
            AccountPlan parent = repository.findById(dto.getParentAccountId()).orElse(null);
            account.setParentAccount(parent);
        }

        return toDto(repository.save(account));
    }

    @Override
    public void delete(String id) {
        AccountPlan account = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Account not found"));
        repository.delete(account);
    }

    public AccountPlanDto toDto(AccountPlan a) {
        return AccountPlanDto.builder()
                .id(a.getId())
                .created(a.getCreated())
                .modified(a.getModified())
                .companyId(a.getCompany().getId())
                .code(a.getCode())
                .name(a.getName())
                .type(a.getType())
                .parentAccountId(a.getParentAccount() != null ? a.getParentAccount().getId() : null)
                .build();
    }

    public AccountPlan toEntity(AccountPlanDto dto) {
        Company company = companyRepository.findById(dto.getCompanyId())
                .orElseThrow(() -> new EntityNotFoundException("Company not found"));

        AccountPlan parent = null;
        if (dto.getParentAccountId() != null) {
            parent = repository.findById(dto.getParentAccountId())
                    .orElseThrow(() -> new EntityNotFoundException("Parent account not found"));
        }

        AccountPlan entity = new AccountPlan();
        entity.setCompany(company);
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setParentAccount(parent);
        return entity;
    }
}
