package com.example.Library.Management.System.service.impl;

import com.example.Library.Management.System.dto.BookDto;

import com.example.Library.Management.System.model.Book;
import com.example.Library.Management.System.model.Category;
import com.example.Library.Management.System.model.Status;
import com.example.Library.Management.System.repository.BookRepository;
import com.example.Library.Management.System.repository.CategoryRepository;
import com.example.Library.Management.System.service.BookService;
import com.example.Library.Management.System.service.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public void createBook(BookDto dto) {

        if (dto != null){
            Book book = bookMapper.toEntity(dto);
            book.setStatus(Status.AVAILABLE);
            bookRepository.save(book);
        }
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findBookById(id);
    }

    @Override
    public void updateBookById(Long id, BookDto bookDto) {
        Book book = bookMapper.toEntity(bookDto);
        book.setId(id);
        bookRepository.save(book);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
