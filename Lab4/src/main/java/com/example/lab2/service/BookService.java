package com.example.lab2.service;

import com.example.lab2.model.Book;
import com.example.lab2.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    final BookRepository bookRepository;
    final AuditService auditService;

    public BookService(BookRepository bookRepository, AuditService auditService) {
        this.bookRepository = bookRepository;
        this.auditService = auditService;
    }

    public Book findById(Long id){
        return bookRepository.findById(id).orElseThrow();
    }

    public Book create(Book book) {
        bookRepository.saveAndFlush(book);
        auditService.log(book, "book", AuditService.EVENT_CREATE);
        return book;
    }

    public Book update(Book newBook) {
        Book oldBook = bookRepository.findById(newBook.getBookId()).orElseThrow();

        auditService.log(oldBook, newBook, "book", AuditService.EVENT_UPDATE);

        return bookRepository.saveAndFlush(newBook);
    }

    public Book delete(Long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(book);

        auditService.log(book, "book", AuditService.EVENT_DELETE);

        return book;
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }
}
