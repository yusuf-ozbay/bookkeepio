package org.example.bookkeepio.Currency;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.example.bookkeepio.library.AbstractEntity;

@Entity
@Table(name = "currency")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Currency extends AbstractEntity {

    // bu sınıf sistemde kullanılacak para birimlerini tanımlar

    // Para birimi kodu (örnek: TRY, USD)
    @Column(nullable = false, unique = true)
    private String code;

    // Para biriminin tam adı
    @Column(nullable = false)
    private String name;
}
