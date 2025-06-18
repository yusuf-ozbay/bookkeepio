package org.example.bookkeepio.accountplan;


import lombok.RequiredArgsConstructor;
import org.example.bookkeepio.library.BaseController;
import org.example.bookkeepio.library.DataResponse;
import org.example.bookkeepio.library.Response;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account-plans")
@RequiredArgsConstructor
public class AccountPlanController extends BaseController {

    private final AccountPlanService service;

    @PostMapping
    public Response<AccountPlanResponse> create(@RequestBody AccountPlanRequest request) {
        return respond(AccountPlanResponse.toResponse(service.create(request.toDto())));
    }

    @GetMapping
    public Response<DataResponse<AccountPlanResponse>> getAll() {
        List<AccountPlanDto> all = service.getAll();
        return respond(all.stream().map(AccountPlanResponse::toResponse).toList());
    }

    @PutMapping("/{id}")
    public Response<AccountPlanResponse> update(@PathVariable String id, @RequestBody AccountPlanRequest request) {
        return respond(AccountPlanResponse.toResponse(service.update(id, request.toDto())));
    }

    @DeleteMapping("/{id}")
    public Response<Void> delete(@PathVariable String id) {
        service.delete(id);
        return respondSuccess();
    }
}
