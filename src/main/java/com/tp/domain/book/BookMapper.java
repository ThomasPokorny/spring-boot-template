package com.tp.domain.book;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "id", ignore = true)
    Book toEntity(BookCreateUpdateDto dto);

    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Book book, BookCreateUpdateDto dto);

    BookDto toDto(Book entity);
}
