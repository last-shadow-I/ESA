package com.example.lab1.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.CascadeType.ALL;

@Entity(name = "user")
@Table(name = "library_user")
@NamedQuery(name = "LibraryUser.getAll", query = "SELECT a from user a ORDER BY libraryUserId ASC")
@NamedQuery(name = "Book.getIds", query = "SELECT a.libraryUserId from user a") //?
public class LibraryUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "library_user_id")
    private Long libraryUserId;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "age", nullable = false)
    private Long age;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "library_user_id", nullable = true)
    private List<Book> books;

    public LibraryUser() {}

    public LibraryUser(Long libraryUserId) {
        this.libraryUserId = libraryUserId;
    }

    public Long getLibraryUserId() {
        return libraryUserId;
    }

    public void setLibraryUserId(Long libraryUserId) {
        this.libraryUserId = libraryUserId;
    }

    public LibraryUser(String fullName, Long age, String address, String phoneNumber) {
        this.fullName = fullName;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
        book.setLibraryUser(this);
        book.setLibraryUserId(this.libraryUserId);
    }

    public void removeBook(Book book) {
        books.remove(book);
        book.setLibraryUser(null);
        book.setLibraryUserId(null);
    }

    @Override
    public String toString() {
        return fullName + ", " + age;
    }
}
