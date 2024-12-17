package com.example.Library.Management.System.service.impl;

import com.example.Library.Management.System.dto.UserDto;
import com.example.Library.Management.System.model.Transaction;
import com.example.Library.Management.System.model.User;
import com.example.Library.Management.System.repository.UserRepository;
import com.example.Library.Management.System.service.UserService;
import com.example.Library.Management.System.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public void createUser(User user) {
        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public List<Transaction> findAllByUserId(Long id) {
        return this.userRepository.findAllTransactionByUserId(id);
    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUserById(Long id) {
        this.userRepository.deleteById(id);
    }
}
