package com.example.Library.Management.System.repository;

import com.example.Library.Management.System.model.Transaction;
import com.example.Library.Management.System.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT t FROM Transaction t WHERE t.user.id = :userId")
    List<Transaction> findAllTransactionByUserId(Long userId);

}
