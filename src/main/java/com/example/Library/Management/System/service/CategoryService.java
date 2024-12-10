package com.example.Library.Management.System.service;

import com.example.Library.Management.System.dto.CategoryDto;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

    void createCategory(CategoryDto categoryDto);

    CategoryDto getCategoryByName(String name);


}
