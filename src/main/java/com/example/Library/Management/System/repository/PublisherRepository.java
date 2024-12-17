package com.example.Library.Management.System.repository;

import com.example.Library.Management.System.model.Book;
import com.example.Library.Management.System.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    @Query("SELECT b FROM Book b WHERE b.publisher.id=:publisherId")
    List<Book> findAllBookByPublisherId(Long publisherId);
}
