package com.tp.util;

import com.tp.domain.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDatabaseCleaner {
    private final BookRepository bookRepository;
    public void clean() {
        bookRepository.deleteAll();
    }
}
