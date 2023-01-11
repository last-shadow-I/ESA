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

    //TODO Удалить комментарии

//    @GetMapping("/add")
//    public String addLibraryUserGet(Model model){
//        model.addAttribute("user", new LibraryUser());
//        return "addLibraryUser";
//    }
//    @PostMapping("/add")
//    public String addLibraryUserPost(@ModelAttribute("user") LibraryUser libraryUser, BindingResult bindingResult){
//        libraryUserRepository.save(libraryUser);
//        return "redirect:/";
//    }
//    @GetMapping("/edit")
//    public String editLibraryUserGet(@RequestParam Long libraryUserId, Model model){
//        Optional<LibraryUser> optionalLibraryUser= libraryUserRepository.findById(libraryUserId);
//        LibraryUser libraryUser = optionalLibraryUser.get();
//        model.addAttribute("user", libraryUser);
//        return "editLibraryUser";
//    }
//    @PostMapping("/edit")
//    public String editLibraryUserPost(@ModelAttribute("user") LibraryUser libraryUser, BindingResult bindingResult){
//        if (!bindingResult.hasErrors())
//            libraryUserRepository.save(libraryUser);
//        return "redirect:/";
//    }
//
//    @GetMapping("/remove")
//    public String removeLibraryUserGet(@RequestParam Long libraryUserId){
//        libraryUserRepository.deleteById(libraryUserId);
//        return "redirect:/";
//    }
}
