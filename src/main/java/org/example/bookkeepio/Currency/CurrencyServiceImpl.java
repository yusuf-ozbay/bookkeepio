package org.example.bookkeepio.Currency;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository repository;

    @Override
    public CurrencyDto createCurrency(CurrencyDto dto) {
        repository.findByCode(dto.getCode()).ifPresent(c -> {
            throw new EntityExistsException("Currency already exists");
        });
        return toDto(repository.save(toEntity(dto)));
    }

    @Override
    public List<CurrencyDto> getAllCurrencies() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public CurrencyDto updateCurrency(String id, CurrencyDto dto) {
        Currency currency = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        currency.setCode(dto.getCode());
        currency.setName(dto.getName());
        return toDto(repository.save(currency));
    }

    @Override
    public void deleteCurrency(String id) {
        Currency currency = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Currency not found"));
        repository.delete(currency);
    }

    public CurrencyDto toDto(Currency entity) {
        return CurrencyDto.builder()
                .id(entity.getId())
                .created(entity.getCreated())
                .modified(entity.getModified())
                .code(entity.getCode())
                .name(entity.getName())
                .build();
    }

    public Currency toEntity(CurrencyDto dto) {
        Currency c = new Currency();
        c.setCode(dto.getCode());
        c.setName(dto.getName());
        return c;
    }
}
