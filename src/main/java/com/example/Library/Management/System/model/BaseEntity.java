package com.example.Library.Management.System.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    @OneToOne
    @JoinColumn(name = "created_by_user_id")
    private User createdBy;

    @OneToOne
    @JoinColumn(name = "updated_by_user_id")
    private User updatedBy;

    @OneToOne
    @JoinColumn(name = "deleted_by_user_id")
    private User deletedBy;


}
