package com.example.Library.Management.System.service;

import com.example.Library.Management.System.dto.BookDto;
import org.springframework.stereotype.Service;

@Service
public interface BookService {

    void createBook(BookDto dto);

}
