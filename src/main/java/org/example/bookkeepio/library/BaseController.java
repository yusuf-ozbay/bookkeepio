package org.example.bookkeepio.library;

import org.springframework.data.domain.Page;

import java.util.List;

public abstract class BaseController {

    protected <T> Response<T> respond(T data) {
        return ResponseBuilder.success(data);
    }

    protected Response<Void> respondSuccess() {
        return ResponseBuilder.success();
    }

    protected <T> Response<DataResponse<T>> respond(List<T> list) {
        return ResponseBuilder.successList(list);
    }
}
