package com.example.lab1.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "book")
@Table(name = "book")
@NamedQuery(name = "book.getAll", query = "SELECT a from book a ORDER BY bookId ASC")
//a.bookId,a.title,a.publisher,a.yearOfPublication
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "publisher", nullable = false)
    private String publisher;

    @Column(name = "year_of_publication", nullable = false)
    private Long yearOfPublication;

    @Column(name = "library_user_id", nullable = true)
    private Long libraryUserId;

    @ManyToOne
    @JoinColumn(name = "library_user_id", insertable = false, updatable = false, nullable = true)
    private LibraryUser libraryUser;

    public Book() {
    }

    public Book(Long bookId) {
        this.bookId = bookId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Book(String author, String title, String publisher, Long yearOfPublication) {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.yearOfPublication = yearOfPublication;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Long getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Long yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    //исправить !!!
    public Long getLibraryUserId() {
        return libraryUserId;
    }

    public void setLibraryUserId(Long libraryUserId) {
        this.libraryUserId = libraryUserId;
    }

    public void setLibraryUser(LibraryUser libraryUser) {
        this.libraryUser = libraryUser;
    }

    public LibraryUser getLibraryUser() {
        return libraryUser;
    }

    @Override
    public String toString() {
        String fullName;
        String authorName;
        if(this.libraryUser == null) {
            fullName = "в библиотеке";
        } else {
            fullName = this.libraryUser.getFullName();
        }
        return this.author + ", " + this.title + " / " + this.publisher + ", " + this.yearOfPublication + ". Находится: " + fullName;
    }
}

