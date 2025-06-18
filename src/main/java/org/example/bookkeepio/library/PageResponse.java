package org.example.bookkeepio.library;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T> {
    private List<T> items;
    private long total;
    private int page;
    private int size;
}
