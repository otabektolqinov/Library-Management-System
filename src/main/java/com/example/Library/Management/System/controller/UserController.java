package com.example.Library.Management.System.controller;

import com.example.Library.Management.System.dto.UserDto;
import com.example.Library.Management.System.model.User;
import com.example.Library.Management.System.service.UserService;
import com.example.Library.Management.System.service.mapper.UserMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public String hello(Model model) {
        List<User> userList = this.userService.getAllUsers();
        model.addAttribute("users", this.userMapper.toDtoWithAllEntityList(userList));
        return "user-list";
    }

    @GetMapping("/register")
    public String register() {
        return "user-registration";
    }

    @PostMapping("/register")
    public String registerSuccess(@ModelAttribute("user") UserDto dto) {
        System.out.println("Method called");
        userService.createUser(this.userMapper.toEntity(dto));
        return "redirect:/user";
    }

    @GetMapping("/update/{id}")
    public String updateUserPage(@PathVariable Long id, Model model) {
        User user = this.userService.findById(id);
        model.addAttribute("user", this.userMapper.toDto(user));
        return "user-update";
    }

    @PostMapping("/update/*")
    public String updateUser(@ModelAttribute("user") UserDto dto) {
        User user = this.userMapper.toEntity(dto);
        user.setId(dto.getUserId());
        this.userService.createUser(user);
        return "redirect:/user";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        this.userService.deleteUserById(id);
        return "redirect:/user";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }

}
