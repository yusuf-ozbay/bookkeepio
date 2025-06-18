package org.example.bookkeepio;

import jakarta.persistence.*;
import lombok.*;
import org.example.bookkeepio.Currency.Currency;
import org.example.bookkeepio.accountplan.AccountPlan;
import org.example.bookkeepio.library.AbstractEntity;

import java.math.BigDecimal;

@Entity
@Table(name = "currency_revaluation_line")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyRevaluationLine extends AbstractEntity {

    // bu sınıf kur farkı işlemlerinin detaylarını tutar

    @ManyToOne
    private CurrencyRevaluation revaluation;

    @ManyToOne
    private AccountPlan accountPlan;

    private BigDecimal amount;

    @ManyToOne
    private Currency currency;

    private BigDecimal exchangeRate;

    @Enumerated(EnumType.STRING)
    private RevaluationType type;

    public enum RevaluationType {
        GAIN, LOSS
    }
}