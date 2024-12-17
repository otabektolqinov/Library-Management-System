package com.example.Library.Management.System.dto;

import com.example.Library.Management.System.model.BaseEntity;
import com.example.Library.Management.System.model.Role;
import com.example.Library.Management.System.model.Transaction;
import com.example.Library.Management.System.model.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDto {
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
    private Integer age;
    private String address;
    private String phoneNumber;
    private List<Transaction> transactions;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private User createdBy;
    private User updatedBy;
    private User deletedBy;

}