package com.example.Library.Management.System.service.impl;

import com.example.Library.Management.System.dto.CategoryDto;
import com.example.Library.Management.System.model.Category;
import com.example.Library.Management.System.repository.CategoryRepository;
import com.example.Library.Management.System.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public void createCategory(CategoryDto categoryDto) {

        if (categoryDto != null){
            Category category = Category.builder()
                    .name(categoryDto.getName())
                    .build();
            categoryRepository.save(category);
        }

    }

    @Override
    public CategoryDto getCategoryByName(String name) {
        Optional<Category> category = categoryRepository.findCategoryByName(name);

        return category.map(value -> CategoryDto.builder()
                .name(value.getName())
                .build()).orElse(null);


    }


}
