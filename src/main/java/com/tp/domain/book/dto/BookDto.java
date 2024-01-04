package com.tp.domain.book.dto;
import java.util.UUID;
public record BookDto(UUID id, String title, String author, String isbn) {
}
