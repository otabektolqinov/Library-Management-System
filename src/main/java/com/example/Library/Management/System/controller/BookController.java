package com.example.Library.Management.System.controller;

import com.example.Library.Management.System.dto.BookDto;
import com.example.Library.Management.System.model.Book;
import com.example.Library.Management.System.repository.BookRepository;
import com.example.Library.Management.System.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("book")
public class BookController {

    private final BookService bookService;
    private final BookRepository bookRepository;

    @GetMapping("/create")
    public String getBookCreatePage(){
        return "create-book";

    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute BookDto dto){
        bookService.createBook(dto);
        return "redirect:get-all";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }

    @GetMapping("/get-all")
    public String getAllBooks(Model model){
        List<Book> bookList = bookRepository.findAll();
        model.addAttribute("books", bookList);
        return "book-list";
    }

    @GetMapping("/{bookId}")
    public String viewBook(@PathVariable("bookId") Long id, Model model){
        Book book = bookService.getBookById(id);
        model.addAttribute(book);
        return "view-book";
    }

    @GetMapping("/{bookId}/update")
    public String getUpdateBook(@PathVariable("bookId") Long id, Model model){
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("bookId", id);
        return "update-book";
    }

    @PostMapping("/{bookId}/update")
    public String updateBook(@PathVariable("bookId") Long id,
                             @ModelAttribute BookDto bookDto
    )
    {
        bookService.updateBookById(id, bookDto);
        return "redirect:/book/get-all";
    }

    @GetMapping("/{bookId}/delete")
    public String deleteBookPage(@PathVariable("bookId") Long id){
        bookService.deleteBookById(id);
        return "redirect:/book/get-all";
    }

}
