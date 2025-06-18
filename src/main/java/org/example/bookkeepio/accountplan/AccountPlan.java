package org.example.bookkeepio.accountplan;

import jakarta.persistence.*;
import lombok.*;
import org.example.bookkeepio.Company.Company;
import org.example.bookkeepio.library.AbstractEntity;

@Entity
@Table(name = "account_plan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountPlan extends AbstractEntity {

    // bu sınıf tek düzen hesap planını temsil eder

    // Hangi şirkete ait
    @ManyToOne(optional = false)
    @JoinColumn(name = "company_id")
    private Company company;

    // Hesap kodu (örnek: 100, 320)
    @Column(nullable = false)
    private String code;

    // Hesap adı
    @Column(nullable = false)
    private String name;

    // Hesap türü (aktif, pasif, gelir, gider...)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountType type;

    // Varsa üst hesap (hiyerarşik yapı için)
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private AccountPlan parentAccount;

    public enum AccountType {
        ASSET, LIABILITY, EQUITY, INCOME, EXPENSE, MEMORANDUM
    }
}
