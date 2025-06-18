package org.example.bookkeepio;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.example.bookkeepio.Company.Company;
import org.example.bookkeepio.Currency.Currency;
import org.example.bookkeepio.accountplan.AccountPlan;
import org.example.bookkeepio.library.AbstractEntity;

import java.math.BigDecimal;

@Entity
@Table(name = "account_balance_snapshot")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountBalanceSnapshot extends AbstractEntity {

    // bu sınıf her hesap için yıl/ay bazında açılış bakiyesini tutar

    @ManyToOne
    private AccountPlan accountPlan;

    @ManyToOne
    private Company company;

    @ManyToOne
    private Currency currency;

    // Açılış bakiyesi
    private BigDecimal openingBalance;

    // Yıl (örnek: 2025)
    private int year;

    // Dönem/Ay (örnek: 1 = Ocak)
    private int period;
}
