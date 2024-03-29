package com.tp.domain.book;

import com.tp.domain.book.dto.BookCreateUpdateDto;
import com.tp.domain.book.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "id", ignore = true)
    Book toEntity(BookCreateUpdateDto dto);

    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Book book, BookCreateUpdateDto dto);

    BookDto toDto(Book entity);

    default Page<BookDto> toListDtos(Page<Book> books) {
        return books.map(this::toDto);
    }
}
