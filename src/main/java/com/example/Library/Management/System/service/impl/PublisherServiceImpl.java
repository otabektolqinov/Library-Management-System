package com.example.Library.Management.System.service.impl;

import com.example.Library.Management.System.model.Book;
import com.example.Library.Management.System.model.Publisher;
import com.example.Library.Management.System.repository.PublisherRepository;
import com.example.Library.Management.System.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;

    @Override
    public List<Publisher> getAllPublisher() {
        return this.publisherRepository.findAll();
    }

    @Override
    public List<Book> findAllBookById(Long id) {
        return this.publisherRepository.findAllBookByPublisherId(id);
    }

    @Override
    public void createPublisher(Publisher publisher) {
        this.publisherRepository.save(publisher);
    }

    @Override
    public Publisher findById(Long id) {
        return this.publisherRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        this.publisherRepository.deleteById(id);
    }


}
