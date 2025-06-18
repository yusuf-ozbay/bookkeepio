package org.example.bookkeepio;

import jakarta.persistence.*;
import lombok.*;
import org.example.bookkeepio.Company.Company;
import org.example.bookkeepio.library.AbstractEntity;

import java.math.BigDecimal;

@Entity
@Table(name = "tax_transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaxTransaction extends AbstractEntity {

    // bu sınıf fiş satırlarına bağlı vergi hesaplamalarını tutar

    @ManyToOne
    private Company company;

    @ManyToOne
    private JournalEntryLine journalEntryLine;

    @ManyToOne
    private TaxType taxType;

    private BigDecimal amount;
}
