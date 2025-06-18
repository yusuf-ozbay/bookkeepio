package org.example.bookkeepio.exchangerate;



import java.util.List;

public interface ExchangeRateService {
    ExchangeRateDto create(ExchangeRateDto dto);
    List<ExchangeRateDto> getAll();
    ExchangeRateDto update(String id, ExchangeRateDto dto);
    void delete(String id);
}
