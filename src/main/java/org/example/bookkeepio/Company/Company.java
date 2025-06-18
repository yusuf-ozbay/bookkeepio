package org.example.bookkeepio.Company;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.example.bookkeepio.library.AbstractEntity;

@Entity
@Table(name = "company")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company extends AbstractEntity {

    //bu sınıf şirket bilgilerini tanımalar

    // Şirketin adı
    @Column(nullable = false)
    private String name;

    // Vergi numarası
    @Column(nullable = false)
    private String taxNumber;

    // Şirketin adresi
    private String address;

    // Varsayılan para birimi (TRY, USD vb.)
    @Column(nullable = false)
    private String defaultCurrencyId;

    // Çoklu para birimi desteği aktif mi?
    private Boolean multiCurrencyEnabled;

    // Çok şubeli yapı destekleniyor mu?
    private Boolean multiBranchEnabled;
}
