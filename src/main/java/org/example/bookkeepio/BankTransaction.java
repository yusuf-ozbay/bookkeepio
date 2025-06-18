package org.example.bookkeepio;

import jakarta.persistence.*;
import lombok.*;
import org.example.bookkeepio.Company.Company;
import org.example.bookkeepio.Currency.Currency;
import org.example.bookkeepio.accountplan.AccountPlan;
import org.example.bookkeepio.library.AbstractEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "bank_transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankTransaction extends AbstractEntity {

    // bu sınıf banka hesapları üzerindeki işlemleri tutar

    @ManyToOne
    private Company company;

    @OneToOne
    private JournalEntry journalEntry;

    private LocalDate transactionDate;

    // Banka hesabı
    @ManyToOne
    private AccountPlan bankAccount;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private BigDecimal amount;

    @ManyToOne
    private Currency currency;

    private String referenceNumber;

    public enum TransactionType {
        IN, OUT
    }
}
