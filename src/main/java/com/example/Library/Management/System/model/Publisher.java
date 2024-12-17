package com.example.Library.Management.System.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "publishers")
public class Publisher extends BaseEntity{

    private String name;
    @Column(columnDefinition = "TEXT")
    private String address;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String phoneNumber;
    @Column(columnDefinition = "TEXT")
    private String imageUrl;
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private List<Book> bookList;

}
