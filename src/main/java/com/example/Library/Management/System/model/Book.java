package com.example.Library.Management.System.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book extends BaseEntity{

    private String title;
    private String author;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String language;
    private Integer pages;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
    private LocalDate publishedDate;
    @OneToOne(fetch = FetchType.LAZY)
    private Audio audio;
    @OneToOne(fetch = FetchType.LAZY)
    private BookFile file;
    private Long count;
    @OneToMany(mappedBy = "book")
    private List<Transaction> transactions;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
    @Column(columnDefinition = "TEXT")
    private String imageUrl;
    @Enumerated(EnumType.STRING)
    private Status status;

}