package com.example.lab2.controller.api;

import com.example.lab2.model.LibraryUser;
import com.example.lab2.repository.LibraryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/users", produces = {"application/json", "application/xml"})
public class LibraryUserController {

    @Autowired
    LibraryUserRepository libraryUserRepository;

    @GetMapping("/{id}")
    public LibraryUser findById(@PathVariable Long id){
        return libraryUserRepository.findById(id).orElseThrow();
    }

    @GetMapping("/all")
    public List<LibraryUser> findAll(){
        return libraryUserRepository.findAll();
    }

    @PostMapping("/edit")
    public void edit(@RequestBody LibraryUser libraryUser){
        libraryUserRepository.saveAndFlush(libraryUser);
    }

    @PostMapping("/add")
    public LibraryUser add(@RequestBody LibraryUser libraryUser){
        libraryUserRepository.saveAndFlush(libraryUser);
        return libraryUser;
    }

    @DeleteMapping("/remove/{id}")
    public void remove(@PathVariable Long id){
        LibraryUser libraryUser = libraryUserRepository.findById(id).orElseThrow();
        libraryUserRepository.delete(libraryUser);
    }

}
