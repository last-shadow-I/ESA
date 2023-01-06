package com.example.lab2.repository;

import com.example.lab2.model.LibraryUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryUserPepository extends JpaRepository<LibraryUser, Long> {


}
