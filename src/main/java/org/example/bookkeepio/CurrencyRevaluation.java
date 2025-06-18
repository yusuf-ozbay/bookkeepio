package org.example.bookkeepio;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.example.bookkeepio.Company.Company;
import org.example.bookkeepio.library.AbstractEntity;

import java.time.LocalDate;

@Entity
@Table(name = "currency_revaluation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyRevaluation extends AbstractEntity {

    // bu sınıf kur farkı işlemlerinin ana kaydını tutar

    @ManyToOne
    private Company company;

    private LocalDate date;

    private String description;
}