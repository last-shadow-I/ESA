package com.example.lab2.controller.api;

import com.example.lab2.model.Book;
import com.example.lab2.repository.BookRepository;
import com.example.lab2.repository.LibraryUserRepository;
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
    BookRepository bookRepository;

    @Autowired
    LibraryUserRepository libraryUserRepository;

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id){
        return bookRepository.findById(id).orElseThrow();
    }

    @GetMapping("/all")
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    @PostMapping("/edit")
    public void edit(@RequestBody Book book){
        bookRepository.saveAndFlush(book);
    }

    @PostMapping("/add")
    public Book add(@RequestBody Book book){
        bookRepository.saveAndFlush(book);
        return book;
    }

    @DeleteMapping("/remove/{id}")
    public void remove(@PathVariable Long id){
        Book book = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(book);
    }
}
