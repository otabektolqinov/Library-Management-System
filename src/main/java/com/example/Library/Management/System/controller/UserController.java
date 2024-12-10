package com.example.Library.Management.System.controller;

import com.example.Library.Management.System.model.User;
import com.example.Library.Management.System.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Controller
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public String hello(){
        return "hello";
    }

    @GetMapping("/register")
    public String register(){
        return "user-registration";
    }

    @PostMapping("/register")
    public String registerSuccess(@ModelAttribute("user") User user, Model model){
        System.out.println("Method called");
        userService.createUser(user);
        System.out.println(user.getAddress());
        return "redirect:/user/success";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }

}
