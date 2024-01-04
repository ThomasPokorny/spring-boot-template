package com.tp.domain.book;

import com.tp.domain.book.dto.BookCreateUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository repository;
    private final BookMapper mapper;

    public Page<Book> getBooks(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Book createBook(BookCreateUpdateDto bookCreateDto) {
        final var book = mapper.toEntity(bookCreateDto);
        return repository.save(book);
    }

    public Book getBook(UUID id) {
        return findBook(id);
    }

    public Book updateBook(UUID id, BookCreateUpdateDto bookCreateDto) {
        final var book = findBook(id);
        mapper.updateEntity(book, bookCreateDto);
        return repository.save(book);
    }

    public void deleteBook(UUID id) {
        final var book = findBook(id);
        repository.delete(book);
    }

    private Book findBook(UUID id) {
        return repository.findById(id).orElseThrow(() -> {
            // TODO: proper error handling
            throw new RuntimeException("Book not found");
        });
    }
}
