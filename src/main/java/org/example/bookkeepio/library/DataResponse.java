package org.example.bookkeepio.library;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse<T> {
    private List<T> items;
}
