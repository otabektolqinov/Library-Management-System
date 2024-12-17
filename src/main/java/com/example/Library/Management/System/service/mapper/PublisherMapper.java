package com.example.Library.Management.System.service.mapper;

import com.example.Library.Management.System.dto.PublisherDto;
import com.example.Library.Management.System.model.Publisher;
import com.example.Library.Management.System.service.impl.PublisherServiceImpl;
import lombok.RequiredArgsConstructor;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Mapper(componentModel = "spring")
//@RequiredArgsConstructor
public abstract class PublisherMapper {

    @Autowired
    protected PublisherServiceImpl publisherService;

    // Basic entity-to-DTO mapping
    @Named(value = "toDto")
    @Mapping(target = "publisherId", source = "id")
    @Mapping(target = "bookList", ignore = true)
    public abstract PublisherDto toDto(Publisher publisher);

    // Basic DTO-to-entity mapping
    @Mapping(target = "bookList", ignore = true)
    public abstract Publisher toEntity(PublisherDto publisherDto);

    // List mappings for entities and DTOs
    @Mapping(target = "publisherId", source = "id")
    @Mapping(target = "bookList", expression = "java(this.publisherService.findAllBookById(publisher.getId()))")
    public abstract PublisherDto toDtoWithAllEntity(Publisher publisher);


    // Custom mapping method for nested relationships or specific fields
    @IterableMapping(qualifiedByName = "toDto")
    @Mapping(target = "publisherId", source = "id")
    public abstract List<PublisherDto> toDtoWithAllEntityList(List<Publisher> users);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Publisher updatedUserAllField(@MappingTarget Publisher publisher, PublisherDto dto);
}
