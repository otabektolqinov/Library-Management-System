package com.example.Library.Management.System.service.impl;

import com.example.Library.Management.System.dto.BookDto;
import com.example.Library.Management.System.model.Book;
import com.example.Library.Management.System.model.Category;
import com.example.Library.Management.System.model.Status;
import com.example.Library.Management.System.repository.BookRepository;
import com.example.Library.Management.System.repository.CategoryRepository;
import com.example.Library.Management.System.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;

    @Override
    public void createBook(BookDto dto) {

        if (dto != null){
            Book book = new Book();
            if (categoryRepository.findCategoryByName(dto.getCategoryDto()).isEmpty()){
                Category category = Category.builder()
                        .name(dto.getCategoryDto())
                        .build();
                Category saved = categoryRepository.save(category);
                book.setCategory(saved);

            } else {
                book.setCategory(categoryRepository.findCategoryByName(dto.getCategoryDto()).get());
            }

            book = Book.builder()
                    .author(dto.getAuthor())
                    .count(dto.getCount())
                    .pages(dto.getPages())
                    .title(dto.getTitle())
                    .description(dto.getDescription())
                    .language(dto.getLanguage())
                    .imageUrl(dto.getImageUrl())
                    .status(Status.AVAILABLE)
                    .publishedDate(dto.getPublishedDate())
                    .build();
            bookRepository.save(book);
        }
    }
}
