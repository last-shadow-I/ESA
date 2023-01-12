package com.example.lab2.repository;

import com.example.lab2.model.LibraryUserAudit;
import com.example.lab2.model.LibraryUserAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryUserAuditRepository extends JpaRepository<LibraryUserAudit, Long>{
}
