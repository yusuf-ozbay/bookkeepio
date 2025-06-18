package org.example.bookkeepio;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;
import org.example.bookkeepio.Company.Company;
import org.example.bookkeepio.Currency.Currency;
import org.example.bookkeepio.accountplan.AccountPlan;
import org.example.bookkeepio.library.AbstractEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "cash_transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CashTransaction extends AbstractEntity {

    // bu sınıf kasa giriş/çıkış işlemlerini tutar

    @ManyToOne
    private Company company;

    @OneToOne
    private JournalEntry journalEntry;

    private LocalDate transactionDate;

    // İşlem tipi: Giriş veya Çıkış
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private BigDecimal amount;

    @ManyToOne
    private Currency currency;

    // Kasa hesabı (100 vb.)
    @ManyToOne
    private AccountPlan cashAccount;

    private String description;

    public enum TransactionType {
        IN, OUT
    }
}
