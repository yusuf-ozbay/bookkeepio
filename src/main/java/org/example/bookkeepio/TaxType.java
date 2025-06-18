package org.example.bookkeepio;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.*;
import org.example.bookkeepio.library.AbstractEntity;

import java.math.BigDecimal;

@Entity
@Table(name = "tax_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaxType extends AbstractEntity {

    // bu sınıf KDV, ÖTV gibi vergi türlerini tanımlar

    private String code;

    private String name;

    private BigDecimal percentage;
}
