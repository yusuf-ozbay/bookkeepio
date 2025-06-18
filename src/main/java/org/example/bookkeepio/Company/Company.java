package org.example.bookkeepio.Company;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.example.bookkeepio.library.AbstractEntity;

@Entity
@Table(name = "company")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String taxNumber;

    private String address;

    @Column(nullable = false)
    private String defaultCurrencyId;

    private Boolean multiCurrencyEnabled;

    private Boolean multiBranchEnabled;
}
