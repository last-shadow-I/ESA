package com.example.lab2.controller;

import com.example.lab2.model.LibraryUser;
import com.example.lab2.repository.LibraryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class LibraryUserController {

    @Autowired
    LibraryUserRepository libraryUserRepository;

    @GetMapping("/add")
    public String addLibraryUserGet(Model model){
        model.addAttribute("user", new LibraryUser());
        return "addLibraryUser";
    }
    @PostMapping("/add")
    public String addLibraryUserPost(@ModelAttribute("user") LibraryUser libraryUser, BindingResult bindingResult){
        libraryUserRepository.save(libraryUser);
        return "redirect:/";
    }
    @GetMapping("/edit")
    public String editLibraryUserGet(@RequestParam Long libraryUserId, Model model){
        Optional<LibraryUser> optionalLibraryUser= libraryUserRepository.findById(libraryUserId);
        LibraryUser libraryUser = optionalLibraryUser.get();
        model.addAttribute("user", libraryUser);
        return "editLibraryUser";
    }
    @PostMapping("/edit")
    public String editLibraryUserPost(@ModelAttribute("user") LibraryUser libraryUser, BindingResult bindingResult){
        if (!bindingResult.hasErrors())
            libraryUserRepository.save(libraryUser);
        return "redirect:/";
    }

    @GetMapping("/remove")
    public String removeLibraryUserGet(@RequestParam Long libraryUserId){
        libraryUserRepository.deleteById(libraryUserId);
        return "redirect:/";
    }
}
