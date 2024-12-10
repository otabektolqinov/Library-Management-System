package com.example.Library.Management.System.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book_files")
public class BookFile extends BaseEntity{

    private String fileName;
    private byte[] files;
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
