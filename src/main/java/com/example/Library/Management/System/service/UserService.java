package com.example.Library.Management.System.service;

import com.example.Library.Management.System.dto.UserDto;
import com.example.Library.Management.System.model.Transaction;
import com.example.Library.Management.System.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void createUser(User user);

    List<User> getAllUsers();

    List<Transaction> findAllByUserId(Long id);

    User findById(Long id);

    void deleteUserById(Long id);
}
