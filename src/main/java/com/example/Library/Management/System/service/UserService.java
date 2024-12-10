package com.example.Library.Management.System.service;

import com.example.Library.Management.System.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void createUser(User user);
}
