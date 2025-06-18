package org.example.bookkeepio.Company;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;

    @Override
    public CompanyDto createCompany(CompanyDto dto) {
        repository.findByName(dto.getName()).ifPresent(c -> {
            throw new EntityExistsException("Company already exists");
        });
        return toDto(repository.save(toEntity(dto)));
    }

    @Override
    public List<CompanyDto> getAllCompanies() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public CompanyDto updateCompany(String id, CompanyDto dto) {
        Company company = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        company.setName(dto.getName());
        company.setTaxNumber(dto.getTaxNumber());
        company.setAddress(dto.getAddress());
        company.setDefaultCurrencyId(dto.getDefaultCurrencyId());
        company.setMultiCurrencyEnabled(dto.getMultiCurrencyEnabled());
        company.setMultiBranchEnabled(dto.getMultiBranchEnabled());
        return toDto(repository.save(company));
    }

    @Override
    public void deleteCompany(String id) {
        Company company = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Company not found"));
        repository.delete(company);
    }

    public CompanyDto toDto(Company c) {
        return CompanyDto.builder()
                .id(c.getId())
                .created(c.getCreated())
                .modified(c.getModified())
                .name(c.getName())
                .taxNumber(c.getTaxNumber())
                .address(c.getAddress())
                .defaultCurrencyId(c.getDefaultCurrencyId())
                .multiCurrencyEnabled(c.getMultiCurrencyEnabled())
                .multiBranchEnabled(c.getMultiBranchEnabled())
                .build();
    }

    public Company toEntity(CompanyDto dto) {
        Company c = new Company();
        c.setName(dto.getName());
        c.setTaxNumber(dto.getTaxNumber());
        c.setAddress(dto.getAddress());
        c.setDefaultCurrencyId(dto.getDefaultCurrencyId());
        c.setMultiCurrencyEnabled(dto.getMultiCurrencyEnabled());
        c.setMultiBranchEnabled(dto.getMultiBranchEnabled());
        return c;
    }
}
