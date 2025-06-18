package org.example.bookkeepio.exchangerate;


import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, String> {
    Optional<ExchangeRate> findByCurrency_IdAndDate(String currencyId, LocalDate date);
}
