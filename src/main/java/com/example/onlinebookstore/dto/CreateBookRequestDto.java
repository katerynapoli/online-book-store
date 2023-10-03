package com.example.onlinebookstore.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class CreateBookRequestDto {
    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private String author;

    @NotNull
    @Pattern(regexp = "\\d{3}-\\d{10}")
    private String isbn;

    @NotNull
    @DecimalMin(value = "0.00", inclusive = false)
    private BigDecimal price;

    @NotNull
    @NotEmpty
    private String description;

    @NotNull
    @NotEmpty
    private String coverImage;
}
