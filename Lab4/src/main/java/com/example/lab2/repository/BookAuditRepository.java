package com.example.lab2.repository;

import com.example.lab2.model.BookAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookAuditRepository extends JpaRepository<BookAudit, Long> {
}
