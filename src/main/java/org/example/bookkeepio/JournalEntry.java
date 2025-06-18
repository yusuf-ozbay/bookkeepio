package org.example.bookkeepio;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.example.bookkeepio.Company.Company;
import org.example.bookkeepio.Currency.Currency;
import org.example.bookkeepio.library.AbstractEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "journal_entry")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JournalEntry extends AbstractEntity {

    // bu sınıf muhasebe fişini (yevmiye kaydı) temsil eder

    @ManyToOne
    private Company company;

    // Belge numarası
    private String documentNumber;

    // Fiş tarihi
    private LocalDate date;

    // Açıklama
    private String description;

    // Toplam borç
    private BigDecimal totalDebit;

    // Toplam alacak
    private BigDecimal totalCredit;

    // Fişin işlendiği para birimi
    @ManyToOne
    private Currency currency;

    // Kurun geçerli olduğu tarih
    private LocalDate exchangeRateDate;
}
