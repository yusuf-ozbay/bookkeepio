package org.example.bookkeepio.Company;

import org.example.bookkeepio.Company.CompanyDto;

import java.util.List;

public interface CompanyService {
    CompanyDto createCompany(CompanyDto dto);
    List<CompanyDto> getAllCompanies();
    CompanyDto updateCompany(String id, CompanyDto dto);
    void deleteCompany(String id);
}
