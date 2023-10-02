package com.example.onlinebookstore.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookSearchParameters {
    @NotNull
    private String[] titles;

    @NotNull
    private String[] authors;
}
