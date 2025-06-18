package org.example.bookkeepio.Company;

import org.example.bookkeepio.Company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, String> {
    Optional<Company> findByName(String name);
}
