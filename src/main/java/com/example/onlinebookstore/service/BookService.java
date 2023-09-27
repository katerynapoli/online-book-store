package com.example.onlinebookstore.service;

import com.example.onlinebookstore.dto.BookDto;
import com.example.onlinebookstore.dto.BookSearchParameters;
import com.example.onlinebookstore.dto.CreateBookRequestDto;
import java.util.List;

public interface BookService {
    BookDto save(CreateBookRequestDto bookRequestDto);

    List<BookDto> getAll();

    BookDto getById(Long id);

    List<BookDto> search(BookSearchParameters params);

    BookDto updateById(Long id, CreateBookRequestDto bookRequestDto);

    void deleteById(Long id);
}
