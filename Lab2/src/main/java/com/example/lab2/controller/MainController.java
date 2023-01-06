package com.example.lab2.controller;

import com.example.lab2.model.Book;
import com.example.lab2.model.LibraryUser;
import com.example.lab2.repository.BookRepository;
import com.example.lab2.repository.LibraryUserPepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    LibraryUserPepository libraryUserPepository;

    @GetMapping()
    public String index(Model model){
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("users", libraryUserPepository.findAll());
        return "index";
    }
}