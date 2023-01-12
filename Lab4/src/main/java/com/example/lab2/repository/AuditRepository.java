package com.example.lab2.repository;

import com.example.lab2.model.DBChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<DBChange, Long> {
}
