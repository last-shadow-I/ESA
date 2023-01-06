package com.example.lab2.model;

import com.example.lab2.model.LibraryUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "book")
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;
    @Basic()
    @Column(name = "author", nullable = false)
    private String author;
    @Basic()
    @Column(name = "title", nullable = false)
    private String title;
    @Basic()
    @Column(name = "publisher", nullable = false)
    private String publisher;
    @Basic()
    @Column(name = "year_of_publication", nullable = false)
    private Long yearOfPublication;

    @Basic()
    @Column(name = "library_user_id", nullable = true)
    private Long libraryUserId;

    @ManyToOne
    @JoinColumn(name = "library_user_id", insertable = false, updatable = false, nullable = true)
    private LibraryUser libraryUser = null;

    public Book(String author, String title, String publisher, Long yearOfPublication, LibraryUser libraryUser) {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.yearOfPublication = yearOfPublication;
        if (libraryUser != null)
            libraryUser.addBook(this);
    }

    public Long getLibraryUserId() {
        return libraryUserId;
    }

    public void setLibraryUserId(Long libraryUserId) {
        this.libraryUserId = libraryUserId;
    }

    public void setLibraryUser(LibraryUser libraryUser){
        if (libraryUser != null){
            this.libraryUser = libraryUser;
            this.libraryUserId = libraryUser.getLibraryUserId();
        }
        else{
            this.libraryUserId = null;
            this.libraryUser= null;
        }
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

    public String getPlace(){
        String place;
        if(this.libraryUser == null) {
            place = "В библиотеке";
        } else {
            place = this.libraryUser.getFullName();
        }
        return place;
    }
}
