package org.example.bookkeepio.exchangerate;


import jakarta.persistence.*;
import lombok.*;
import org.example.bookkeepio.Currency.Currency;
import org.example.bookkeepio.library.AbstractEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "exchange_rate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRate extends AbstractEntity {

    // bu sınıf döviz kurlarını tutar (örnek: 1 USD = 27.50 TRY)

    // Hangi para birimine ait kur
    @ManyToOne(optional = false)
    @JoinColumn(name = "currency_id")
    private Currency currency;

    // Kurun geçerli olduğu tarih
    @Column(nullable = false)
    private LocalDate date;

    // Baz para birimine oran (örnek: 27.50)
    @Column(nullable = false, precision = 19, scale = 6)
    private BigDecimal rateToBaseCurrency;
}
