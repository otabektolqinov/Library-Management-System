package com.example.Library.Management.System.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transactions")
public class Transaction extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @Enumerated(EnumType.STRING)
    private ReturnStatus status;
    private LocalDate borrowedDate;
    private LocalDate returnedBeforeDeadline;
    private LocalDate returnDate;


}
