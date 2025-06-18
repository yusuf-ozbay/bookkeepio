package org.example.bookkeepio.library;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MetaResponse {
    private boolean success;
    private String message;

    public static MetaResponse ofSuccess() {
        return new MetaResponse(true, "İşlem başarılı");
    }

    public static MetaResponse ofFailure(String message) {
        return new MetaResponse(false, message);
    }
}
