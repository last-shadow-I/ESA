package com.example.lab2.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "libraryUser")
@Table(name = "library_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "library_user_id")
    private Long libraryUserId;

    @Basic()
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Basic()
    @Column(name = "age", nullable = false)
    private Long age;

    @Basic()
    @Column(name = "address", nullable = false)
    private String address;

    @Basic()
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    //@JoinColumn(name = "library_user_id", nullable = true)
    @OneToMany(mappedBy = "libraryUser")
    private List<Book> books;

    public LibraryUser(String fullName, Long age, String address, String phoneNumber) {
        this.fullName = fullName;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
        book.setLibraryUser(this);
    }

    public void removeBook(Book book) {
        books.remove(book);
        book.setLibraryUser(null);
    }

    @Override
    public String toString() {
        return fullName + ", " + age;
    }
}
