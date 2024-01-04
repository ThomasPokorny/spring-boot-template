package com.tp.domain.book;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/books")
public class BookController {
    private final BookService service;
    private final BookMapper mapper;
}
