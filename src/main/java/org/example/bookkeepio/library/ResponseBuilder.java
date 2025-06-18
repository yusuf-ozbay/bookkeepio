package org.example.bookkeepio.library;

import java.util.List;

public class ResponseBuilder {

    public static <T> Response<T> success(T data) {
        return new Response<>(MetaResponse.ofSuccess(), data);
    }

    public static <T> Response<DataResponse<T>> successList(List<T> items) {
        return new Response<>(MetaResponse.ofSuccess(), new DataResponse<>(items));
    }

    public static Response<Void> success() {
        return new Response<>(MetaResponse.ofSuccess());
    }

    public static Response<Void> failure(String message) {
        return new Response<>(MetaResponse.ofFailure(message));
    }
}
