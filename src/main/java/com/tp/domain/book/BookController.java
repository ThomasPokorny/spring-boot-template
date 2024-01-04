package com.tp.domain.book;

import com.tp.domain.book.dto.BookCreateUpdateDto;
import com.tp.domain.book.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {
    private final BookService service;
    private final BookMapper mapper;

    @GetMapping(path = "/{bookId}")
    public BookDto getBook(@PathVariable UUID bookId) {
        final var book = service.getBook(bookId);
        return mapper.toDto(book);
    }

    @GetMapping
    public Page<BookDto> getBooks(@PageableDefault(size = 1000) @ParameterObject Pageable pageable) {
        final var books = service.getBooks(pageable);
        return mapper.toListDtos(books);
    }

    @PostMapping
    public BookDto createBook(@RequestBody BookCreateUpdateDto createUpdateDto) {
        final var book = service.createBook(createUpdateDto);
        return mapper.toDto(book);
    }

    @PutMapping(path = "/{bookId}")
    public BookDto createBook(@PathVariable UUID bookId, @RequestBody BookCreateUpdateDto createUpdateDto) {
        final var book = service.updateBook(bookId, createUpdateDto);
        return mapper.toDto(book);
    }

    @DeleteMapping(path = "/{bookId}")
    public void deleteBook(@PathVariable UUID bookId) {
        service.deleteBook(bookId);
    }
}
