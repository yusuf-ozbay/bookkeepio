package org.example.bookkeepio;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.example.bookkeepio.Currency.Currency;
import org.example.bookkeepio.accountplan.AccountPlan;
import org.example.bookkeepio.library.AbstractEntity;

import java.math.BigDecimal;

@Entity
@Table(name = "journal_entry_line")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JournalEntryLine extends AbstractEntity {

    // bu sınıf yevmiye fişindeki satırları temsil eder

    @ManyToOne
    private JournalEntry journalEntry;

    // Satır numarası
    private int lineNumber;

    @ManyToOne
    private AccountPlan accountPlan;

    // Varsa cari hesap
    @ManyToOne
    private CustomerVendor customerVendor;

    // Borç tutarı
    private BigDecimal debitAmount;

    // Alacak tutarı
    private BigDecimal creditAmount;

    @ManyToOne
    private Currency currency;

    // Kullanılan kur
    private BigDecimal exchangeRate;
}
