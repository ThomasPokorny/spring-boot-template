package com.tp.domain.book;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toEntity(BookDto dto);
    BookDto toDto(Book entity);
}
