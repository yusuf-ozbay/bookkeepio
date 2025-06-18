package org.example.bookkeepio.exchangerate;


import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.bookkeepio.Currency.CurrencyRepository;
import org.example.bookkeepio.Currency.Currency;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final ExchangeRateRepository repository;
    private final CurrencyRepository currencyRepository;

    @Override
    public ExchangeRateDto create(ExchangeRateDto dto) {
        repository.findByCurrency_IdAndDate(dto.getCurrencyId(), dto.getDate())
                .ifPresent(rate -> { throw new EntityExistsException("Rate already exists for this currency and date"); });

        return toDto(repository.save(toEntity(dto)));
    }

    @Override
    public List<ExchangeRateDto> getAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public ExchangeRateDto update(String id, ExchangeRateDto dto) {
        ExchangeRate rate = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        rate.setDate(dto.getDate());
        rate.setRateToBaseCurrency(dto.getRateToBaseCurrency());
        return toDto(repository.save(rate));
    }

    @Override
    public void delete(String id) {
        ExchangeRate rate = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Exchange rate not found"));
        repository.delete(rate);
    }

    public ExchangeRateDto toDto(ExchangeRate entity) {
        return ExchangeRateDto.builder()
                .id(entity.getId())
                .created(entity.getCreated())
                .modified(entity.getModified())
                .currencyId(entity.getCurrency().getId())
                .date(entity.getDate())
                .rateToBaseCurrency(entity.getRateToBaseCurrency())
                .build();
    }

    public ExchangeRate toEntity(ExchangeRateDto dto) {
        Currency currency = currencyRepository.findById(dto.getCurrencyId())
                .orElseThrow(() -> new EntityNotFoundException("Currency not found"));
        ExchangeRate entity = new ExchangeRate();
        entity.setCurrency(currency);
        entity.setDate(dto.getDate());
        entity.setRateToBaseCurrency(dto.getRateToBaseCurrency());
        return entity;
    }
}
