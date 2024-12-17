package com.example.Library.Management.System.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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
    @OneToMany(mappedBy = "publisher")
    private List<Book> bookList;

}
