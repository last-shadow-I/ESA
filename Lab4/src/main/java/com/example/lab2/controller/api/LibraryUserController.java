package com.example.lab2.controller.api;

import com.example.lab2.model.LibraryUser;
import com.example.lab2.repository.LibraryUserRepository;
import com.example.lab2.service.LibraryUserService;
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
    LibraryUserService libraryUserService;

    @GetMapping("/{id}")
    public LibraryUser findById(@PathVariable Long id){
        return libraryUserService.findById(id);
    }

    @GetMapping("/all")
    public List<LibraryUser> findAll(){
        return libraryUserService.findAll();
    }

    @PostMapping("/edit")
    public void edit(@RequestBody LibraryUser libraryUser){
        libraryUserService.update(libraryUser);
    }

    @PostMapping("/add")
    public LibraryUser add(@RequestBody LibraryUser libraryUser){
        libraryUserService.create(libraryUser);
        return libraryUser;
    }

    @DeleteMapping("/remove/{id}")
    public void remove(@PathVariable Long id){
        libraryUserService.delete(id);
    }

}
