package com.example.Library.Management.System.service;

import com.example.Library.Management.System.dto.BookDto;
import com.example.Library.Management.System.model.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {

    void createBook(BookDto dto);

    Book getBookById(Long id);

    void updateBookById(Long id, BookDto bookDto);

    void deleteBookById(Long id);
}
