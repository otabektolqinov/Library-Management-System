package com.example.Library.Management.System.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "images")
public class Image extends BaseEntity{

    private String name;
    private byte[] image;
//    private Book book;
//    private Publisher publisher;

}
