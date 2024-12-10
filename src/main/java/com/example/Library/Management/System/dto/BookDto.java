package com.example.Library.Management.System.dto;

import com.example.Library.Management.System.model.Audio;
import com.example.Library.Management.System.model.BookFile;
import com.example.Library.Management.System.model.Category;
import com.example.Library.Management.System.model.Publisher;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private String title;
    private String author;
    private String description;
    private String language;
    private Integer pages;
    private Publisher publisher;
    private LocalDate publishedDate;
    private Long count;
    private String categoryDto;
    private String imageUrl;

}
