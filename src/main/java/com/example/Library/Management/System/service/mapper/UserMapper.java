package com.example.Library.Management.System.service.mapper;

import com.example.Library.Management.System.dto.UserDto;
import com.example.Library.Management.System.model.User;
import com.example.Library.Management.System.service.UserService;
import com.example.Library.Management.System.service.impl.UserServiceImpl;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Lazy
    @Autowired
    protected UserServiceImpl userService;

    // Basic entity-to-DTO mapping
    @Named(value = "toDto")
    @Mapping(target = "userId", source = "id")
    @Mapping(target = "transactions", ignore = true)
    public abstract UserDto toDto(User user);

    // Basic DTO-to-entity mapping
    @Mapping(target = "transactions", ignore = true)
    public abstract User toEntity(UserDto userDto);

    // List mappings for entities and DTOs
    @Mapping(target = "userId", source = "id")
    @Mapping(target = "transactions", expression = "java(this.userService.findAllByUserId(users.getId()))")
    public abstract UserDto toDtoWithAllEntity(User users);


    // Custom mapping method for nested relationships or specific fields
    @IterableMapping(qualifiedByName = "toDto")
    @Mapping(target = "userId", source = "id")
    public abstract List<UserDto> toDtoWithAllEntityList(List<User> users);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract User updatedUserAllField(@MappingTarget User users, UserDto dto);
}
