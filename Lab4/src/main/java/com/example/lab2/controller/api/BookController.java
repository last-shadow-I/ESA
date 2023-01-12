package com.example.lab2.controller.api;

import com.example.lab2.model.Book;
import com.example.lab2.repository.BookRepository;
import com.example.lab2.repository.LibraryUserRepository;
import com.example.lab2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/books", produces = {"application/json", "application/xml"})
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id){
        return bookService.findById(id);
    }

    @GetMapping("/all")
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @PostMapping("/edit")
    public void edit(@RequestBody Book book){
        bookService.update(book);
    }

    @PostMapping("/add")
    public Book add(@RequestBody Book book){
        bookService.create(book);
        return book;
    }

    @DeleteMapping("/remove/{id}")
    public void remove(@PathVariable Long id){
        bookService.delete(id);
    }
}
