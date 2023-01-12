package com.example.lab2.model;

import com.example.lab2.model.LibraryUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

@Entity(name = "book")
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable, Mappable {

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

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "library_user_id", nullable = true)
    private LibraryUser libraryUser = null;

    public Book(String author, String title, String publisher, Long yearOfPublication, LibraryUser libraryUser) {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.yearOfPublication = yearOfPublication;
        if (libraryUser != null)
            libraryUser.addBook(this);
    }

    public Book(Long bookId, String author, String title, String publisher, Long yearOfPublication) {
        this.bookId = bookId;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.yearOfPublication = yearOfPublication;
    }

    public void setLibraryUser(LibraryUser libraryUser){
        if (libraryUser != null){
            this.libraryUser = libraryUser;
        }
        else{
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!Objects.equals(bookId, book.bookId)) return false;
        if (!Objects.equals(title, book.title)) return false;
        if (!Objects.equals(author, book.author)) return false;
        if (!Objects.equals(publisher, book.publisher)) return false;
        return Objects.equals(yearOfPublication, book.yearOfPublication);
    }

    @Override
    public int hashCode() {
        int result = bookId != null ? bookId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + (yearOfPublication != null ? yearOfPublication.hashCode() : 0);
        return result;
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

    @Override
    public Map<String, String> toMap() {
        return Map.of("bookId", String.valueOf(bookId),
                "title", String.valueOf(title),
                "author", String.valueOf(author),
                "publisher", String.valueOf(publisher),
                "yearOfPublication", String.valueOf(yearOfPublication));
    }

    public static Book fromMap(Map<String, String> map){
        if(map == null)
            return new Book();
        else {
            String help;
            help = map.get("bookId");
            Long bookId = Long.valueOf(help);

            help = map.get("title");
            String title = help;

            help = map.get("author");
            String author = help;

            help = map.get("publisher");
            String publisher = help;

            help = map.get("yearOfPublication");
            Long yearOfPublication = Long.valueOf(help);

            Book book = new Book(bookId, author, title, publisher, yearOfPublication);
            return book;
        }
    }

}
