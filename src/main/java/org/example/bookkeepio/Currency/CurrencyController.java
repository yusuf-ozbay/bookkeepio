package org.example.bookkeepio.Currency;

import lombok.RequiredArgsConstructor;
import org.example.bookkeepio.library.BaseController;
import org.example.bookkeepio.library.DataResponse;
import org.example.bookkeepio.library.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/currencies")
@RequiredArgsConstructor
public class CurrencyController extends BaseController {

    private final CurrencyService service;

    @PostMapping
    public Response<CurrencyResponse> create(@RequestBody CurrencyRequest request) {
        return respond(CurrencyResponse.toResponse(service.createCurrency(request.toDto())));
    }

    @GetMapping
    public Response<DataResponse<CurrencyResponse>> getAll() {
        return respond(service.getAllCurrencies().stream()
                .map(CurrencyResponse::toResponse)
                .toList());
    }

    @PutMapping("/{id}")
    public Response<CurrencyResponse> update(@PathVariable String id, @RequestBody CurrencyRequest request) {
        return respond(CurrencyResponse.toResponse(service.updateCurrency(id, request.toDto())));
    }

    @DeleteMapping("/{id}")
    public Response<Void> delete(@PathVariable String id) {
        service.deleteCurrency(id);
        return respondSuccess();
    }
}
