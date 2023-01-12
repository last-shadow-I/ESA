package com.example.lab2.model;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Entity(name = "libraryUser")
@Table(name = "library_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryUser implements Serializable, Mappable{

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

    @OneToMany(mappedBy = "libraryUser")
    private List<Book> books;

    public LibraryUser(String fullName, Long age, String address, String phoneNumber) {
        this.fullName = fullName;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public LibraryUser(Long libraryUserId, String fullName, Long age, String address, String phoneNumber) {
        this.libraryUserId = libraryUserId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LibraryUser client = (LibraryUser) o;

        if (!Objects.equals(libraryUserId, client.libraryUserId)) return false;
        if (!Objects.equals(fullName, client.fullName)) return false;
        if (!Objects.equals(age, client.age)) return false;
        if (!Objects.equals(address, client.address)) return false;
        return Objects.equals(phoneNumber, client.phoneNumber);
    }

    @Override
    public int hashCode() {
        int result = libraryUserId != null ? libraryUserId.hashCode() : 0;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }

    @Override
    public Map<String, String> toMap(){
        return Map.of("libraryUserId", String.valueOf(libraryUserId),
                "fullName", String.valueOf(fullName),
                "age", String.valueOf(age),
                "address", String.valueOf(address),
                "phoneNumber",String.valueOf(phoneNumber));
    }

    public static LibraryUser fromMap(Map<String, String> map){
        return map == null ? new LibraryUser() : new LibraryUser(Long.valueOf(map.get("libraryUserId")), map.get("fullName"),
                Long.valueOf(map.get("age")), map.get("address"), map.get("phoneNumber"));
    }
}
