package org.example.bookkeepio.library;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.*;

import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(updatable = false)
    private Date created;

    private Date modified;

    @PrePersist
    public void onCreate() {
        this.created = new Date();
        this.modified = new Date();
    }

    @PreUpdate
    public void onUpdate() {
        this.modified = new Date();
    }
}
