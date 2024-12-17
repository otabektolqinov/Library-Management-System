package com.example.Library.Management.System.service.mapper;

import com.example.Library.Management.System.dto.BookDto;
import com.example.Library.Management.System.model.Book;
import com.example.Library.Management.System.repository.BookRepository;
import com.example.Library.Management.System.repository.CategoryRepository;
import com.example.Library.Management.System.service.CategoryService;
import com.example.Library.Management.System.service.impl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {CategoryServiceImpl.class})
@RequiredArgsConstructor
public abstract class BookMapper {

    @Autowired
    protected CategoryServiceImpl categoryService;

    @Mapping(target = "category", expression = "java(categoryService.findCategoryByName(dto.getCategory()))")
    public abstract Book toEntity(BookDto dto);


//    public abstract Book updateAllFields(Book bookById, BookDto bookDto);

    // public abstract BookDto toDto(Book book);




}

