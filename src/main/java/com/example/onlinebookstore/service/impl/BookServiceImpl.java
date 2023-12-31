package com.example.onlinebookstore.service.impl;

import com.example.onlinebookstore.dto.BookDto;
import com.example.onlinebookstore.dto.BookSearchParameters;
import com.example.onlinebookstore.dto.CreateBookRequestDto;
import com.example.onlinebookstore.exception.EntityNotFoundException;
import com.example.onlinebookstore.mapper.BookMapper;
import com.example.onlinebookstore.model.Book;
import com.example.onlinebookstore.repository.BookRepository;
import com.example.onlinebookstore.repository.BookSpecificationBuilder;
import com.example.onlinebookstore.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookSpecificationBuilder bookSpecificationBuilder;

    @Override
    public BookDto save(CreateBookRequestDto bookRequestDto) {
        Book book = bookMapper.toModel(bookRequestDto);
        bookRepository.save(book);
        return bookMapper.toDto(book);
    }

    @Override
    public List<BookDto> getAll(Pageable pageable) {
        return bookRepository.findAll(pageable).stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto getById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("There is no book with id " + id)
        );
        return bookMapper.toDto(book);
    }

    @Override
    public List<BookDto> search(BookSearchParameters params, Pageable pageable) {
        Specification<Book> bookSpecification = bookSpecificationBuilder.build(params);
        return bookRepository.findAll(bookSpecification, pageable)
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto updateById(Long id, CreateBookRequestDto bookRequestDto) {
        Book bookToUpdate = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("There is no book with id " + id)
        );
        bookToUpdate.setTitle(bookRequestDto.getTitle());
        bookToUpdate.setAuthor(bookRequestDto.getAuthor());
        bookToUpdate.setIsbn(bookRequestDto.getIsbn());
        bookToUpdate.setPrice(bookRequestDto.getPrice());
        bookToUpdate.setDescription(bookRequestDto.getDescription());
        bookToUpdate.setCoverImage(bookRequestDto.getCoverImage());
        return bookMapper.toDto(bookRepository.save(bookToUpdate));
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
