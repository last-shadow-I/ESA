package com.example.lab2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "library_user_audit")
public class LibraryUserAudit {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = true)
    private Long id;


    @Basic()
    @Column(name = "full_name_old", nullable = true)
    private String fullNameOld;

    @Basic()
    @Column(name = "full_name_new", nullable = true)
    private String fullNameNew;

    @Basic()
    @Column(name = "age_old", nullable = true)
    private Long ageOld;

    @Basic()
    @Column(name = "age_new", nullable = true)
    private Long ageNew;

    @Basic()
    @Column(name = "address_old", nullable = true)
    private String addressOld;

    @Basic()
    @Column(name = "address_new", nullable = true)
    private String addressNew;

    @Basic()
    @Column(name = "phone_number_old", nullable = true)
    private String phoneNumberOld;

    @Basic()
    @Column(name = "phone_number_new", nullable = true)
    private String phoneNumberNew;

    public LibraryUserAudit(String fullNameOld, String fullNameNew, Long ageOld, Long ageNew, String addressOld, String addressNew, String phoneNumberOld, String phoneNumberNew) {
        this.fullNameOld = fullNameOld;
        this.fullNameNew = fullNameNew;
        this.ageOld = ageOld;
        this.ageNew = ageNew;
        this.addressOld = addressOld;
        this.addressNew = addressNew;
        this.phoneNumberOld = phoneNumberOld;
        this.phoneNumberNew = phoneNumberNew;
    }
}
