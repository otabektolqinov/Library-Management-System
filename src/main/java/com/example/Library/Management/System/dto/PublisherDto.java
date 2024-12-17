package com.example.Library.Management.System.dto;

import com.example.Library.Management.System.model.Book;
import com.example.Library.Management.System.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PublisherDto {
    private Long publisherId;
    private String name;
    private String address;
    private String description;
    private String phoneNumber;
    private String imageUrl;
    private List<Book> bookList;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private User createdBy;
    private User updatedBy;
    private User deletedBy;
}
