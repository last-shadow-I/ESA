package com.example.lab2.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "book_audit")
public class BookAudit {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "title_old", nullable = true)
    private String titleOld;
    @Basic
    @Column(name = "title_new", nullable = true)
    private String titleNew;
    @Basic
    @Column(name = "author_old", nullable = true)
    private String authorOld;
    @Basic
    @Column(name = "author_new", nullable = true)
    private String authorNew;
    @Basic
    @Column(name = "publisher_old", nullable = true)
    private String publisherOld;
    @Basic
    @Column(name = "publisher_new", nullable = true)
    private String publisherNew;
    @Basic
    @Column(name = "year_of_publication_old", nullable = true)
    private Long yearOfPublicationOld;
    @Basic
    @Column(name = "year_of_publication_new", nullable = true)
    private Long yearOfPublicationNew;

    public BookAudit(String titleOld, String titleNew, String authorOld, String authorNew, String publisherOld, String publisherNew, Long yearOfPublicationOld, Long yearOfPublicationNew) {
        this.titleOld = titleOld;
        this.titleNew = titleNew;
        this.authorOld = authorOld;
        this.authorNew = authorNew;
        this.publisherOld = publisherOld;
        this.publisherNew = publisherNew;
        this.yearOfPublicationOld = yearOfPublicationOld;
        this.yearOfPublicationNew = yearOfPublicationNew;
    }
}
