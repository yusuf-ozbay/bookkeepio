package org.example.bookkeepio;

import jakarta.persistence.*;
import lombok.*;
import org.example.bookkeepio.Company.Company;
import org.example.bookkeepio.Currency.Currency;
import org.example.bookkeepio.library.AbstractEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "invoice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Invoice extends AbstractEntity {

    // bu sınıf alış/satış faturalarını tanımlar

    @ManyToOne
    private Company company;

    @ManyToOne
    private CustomerVendor customerVendor;

    // Fatura numarası
    private String invoiceNumber;

    // Fatura tipi: Satış veya Alış
    @Enumerated(EnumType.STRING)
    private InvoiceType invoiceType;

    private LocalDate date;

    // Vade tarihi
    private LocalDate dueDate;

    @ManyToOne
    private Currency currency;

    private BigDecimal totalNet;

    private BigDecimal totalTax;

    private BigDecimal totalGross;

    // Muhasebe fişi ile ilişkili
    @OneToOne
    private JournalEntry journalEntry;

    public enum InvoiceType {
        PURCHASE, SALE
    }
}
