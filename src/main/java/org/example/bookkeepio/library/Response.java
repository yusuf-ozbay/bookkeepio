package org.example.bookkeepio.library;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Response<T> {
    private MetaResponse meta;
    private T data;

    public Response(MetaResponse meta) {
        this.meta = meta;
    }

    public Response(MetaResponse meta, T data) {
        this.meta = meta;
        this.data = data;
    }
}
