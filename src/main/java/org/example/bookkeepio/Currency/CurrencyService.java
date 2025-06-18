package org.example.bookkeepio.Currency;

import java.util.List;

public interface CurrencyService {
    CurrencyDto createCurrency(CurrencyDto dto);
    List<CurrencyDto> getAllCurrencies();
    CurrencyDto updateCurrency(String id, CurrencyDto dto);
    void deleteCurrency(String id);
}
