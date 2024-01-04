package com.tp.domain.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository repository;
    private final BookMapper mapper;
}
