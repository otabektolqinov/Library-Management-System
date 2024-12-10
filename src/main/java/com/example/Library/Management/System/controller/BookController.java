package com.example.Library.Management.System.controller;

import com.example.Library.Management.System.dto.BookDto;
import com.example.Library.Management.System.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("book")
public class BookController {

    private final BookService bookService;

    @GetMapping("/create")
    public String getBookCreatePage(){
        return "create-book";

    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute BookDto dto, Model model){
        bookService.createBook(dto);
        return "redirect:book/success";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }

    @GetMapping("/get-all")
    public String getAllBooks(){

    }
}
