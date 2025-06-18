package org.example.bookkeepio.Company;

import lombok.RequiredArgsConstructor;
import org.example.bookkeepio.library.BaseController;
import org.example.bookkeepio.library.DataResponse;
import org.example.bookkeepio.library.Response;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController extends BaseController {

    private final CompanyService service;

    @PostMapping
    public Response<CompanyResponse> create(@RequestBody CompanyRequest request) {
        return respond(CompanyResponse.toResponse(service.createCompany(request.toDto())));
    }

    @GetMapping
    public Response<DataResponse<CompanyResponse>> getAll() {
        return respond(service.getAllCompanies().stream()
                .map(CompanyResponse::toResponse).toList());
    }

    @PutMapping("/{id}")
    public Response<CompanyResponse> update(@PathVariable String id, @RequestBody CompanyRequest request) {
        return respond(CompanyResponse.toResponse(service.updateCompany(id, request.toDto())));
    }

    @DeleteMapping("/{id}")
    public Response<Void> delete(@PathVariable String id) {
        service.deleteCompany(id);
        return respondSuccess();
    }
}
