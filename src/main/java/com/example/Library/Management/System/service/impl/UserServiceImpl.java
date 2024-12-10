package com.example.Library.Management.System.service.impl;

import com.example.Library.Management.System.model.User;
import com.example.Library.Management.System.repository.UserRepository;
import com.example.Library.Management.System.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }
}
