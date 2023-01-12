package com.example.lab2.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "audit")
@Data
@NoArgsConstructor
public class DBChange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "entity", nullable = false)
    private String entity;
    @Basic
    @Column(name = "event_type", nullable = false)
    private String eventType;
    @Basic
    @Column(name = "entry_id", nullable = false)
    private Long entryId;
    @Basic
    @Column(name = "time", nullable = false)
    private Date time;

    public DBChange(String entity, Long entryId, String eventType, Date time) {
        this.entity = entity;
        this.entryId = entryId;
        this.eventType = eventType;
        this.time = time;
    }
}
