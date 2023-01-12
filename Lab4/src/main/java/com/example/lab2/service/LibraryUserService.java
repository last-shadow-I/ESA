package com.example.lab2.service;

import com.example.lab2.model.LibraryUser;
import com.example.lab2.repository.LibraryUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryUserService {

    final LibraryUserRepository libraryUserRepository;
    final AuditService auditService;

    public LibraryUserService(LibraryUserRepository libraryUserRepository, AuditService auditService) {
        this.libraryUserRepository = libraryUserRepository;
        this.auditService = auditService;
    }

    public LibraryUser findById(Long id){
        return libraryUserRepository.findById(id).orElseThrow();
    }

    public LibraryUser create(LibraryUser libraryUser) {
        libraryUserRepository.saveAndFlush(libraryUser);

        auditService.log(libraryUser, "libraryUser", AuditService.EVENT_CREATE);

        return libraryUser;
    }

    public LibraryUser update(LibraryUser newLibraryUser){
        LibraryUser oldLibraryUser = libraryUserRepository.findById(newLibraryUser.getLibraryUserId()).orElseThrow();

        auditService.log(oldLibraryUser, newLibraryUser, "libraryUser", AuditService.EVENT_UPDATE);

        return libraryUserRepository.saveAndFlush(newLibraryUser);
    }

    public LibraryUser delete(Long id) {
        LibraryUser libraryUser = libraryUserRepository.findById(id).orElseThrow();
        libraryUserRepository.delete(libraryUser);

        auditService.log(libraryUser, "libraryUser", AuditService.EVENT_DELETE);

        return libraryUser;
    }

    public List<LibraryUser> findAll(){
        return libraryUserRepository.findAll();
    }
}
