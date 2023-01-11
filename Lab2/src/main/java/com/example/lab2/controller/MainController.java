package com.example.lab2.controller;

import com.example.lab2.repository.BookRepository;
import com.example.lab2.repository.LibraryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    LibraryUserRepository libraryUserRepository;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("users", libraryUserRepository.findAll());
        return "index";
    }
}