package com.tp.domain.book;

import com.tp.domain.book.dto.BookCreateUpdateDto;
import com.tp.domain.book.dto.BookDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    @Operation(summary = "Get on specific book",
            description = "Retrieves one specific book by its id")
    public BookDto getBook(@PathVariable UUID bookId) {
        final var book = service.getBook(bookId);
        return mapper.toDto(book);
    }

    @GetMapping
    @Operation(summary = "Gets all books in page range")
    public Page<BookDto> getBooks(@PageableDefault(size = 1000) @ParameterObject Pageable pageable) {
        final var books = service.getBooks(pageable);
        return mapper.toListDtos(books);
    }

    @PostMapping
    @Operation(summary = "Create book instance")
    @ApiResponse(responseCode = "201", description = "Created book")
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto createBook(@RequestBody BookCreateUpdateDto createUpdateDto) {
        final var book = service.createBook(createUpdateDto);
        return mapper.toDto(book);
    }

    @PutMapping(path = "/{bookId}")
    @Operation(summary = "Update Book instance")
    @ApiResponse(responseCode = "204", description = "Book updated")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBook(@PathVariable UUID bookId, @RequestBody BookCreateUpdateDto createUpdateDto) {
        service.updateBook(bookId, createUpdateDto);
    }

    @DeleteMapping(path = "/{bookId}")
    @Operation(summary = "Delete Book instance")
    @ApiResponse(responseCode = "204", description = "Book deleted")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable UUID bookId) {
        service.deleteBook(bookId);
    }
}
