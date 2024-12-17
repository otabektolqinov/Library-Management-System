package com.example.Library.Management.System.service;

import com.example.Library.Management.System.model.Book;
import com.example.Library.Management.System.model.Publisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PublisherService {
    List<Publisher> getAllPublisher();

    List<Book> findAllBookById(Long id);

    void createPublisher(Publisher publisher);

    Publisher findById(Long id);

    void deleteById(Long id);
}
