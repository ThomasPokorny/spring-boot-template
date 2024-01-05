package com.tp.domain.book.dto;

import lombok.Builder;

@Builder
public record BookCreateUpdateDto(String title, String author, String isbn) {
}
