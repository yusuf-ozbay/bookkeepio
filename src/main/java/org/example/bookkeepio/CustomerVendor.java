package org.example.bookkeepio;

import jakarta.persistence.*;
import lombok.*;
import org.example.bookkeepio.Company.Company;
import org.example.bookkeepio.Currency.Currency;
import org.example.bookkeepio.library.AbstractEntity;

@Entity
@Table(name = "customer_vendor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerVendor extends AbstractEntity {

    // bu sınıf müşteri ve tedarikçi bilgilerini tanımlar

    @ManyToOne
    private Company company;

    // Cari tipi (Müşteri, Tedarikçi, Her ikisi)
    @Enumerated(EnumType.STRING)
    private CustomerVendorType type;

    // Cari kodu
    private String code;

    // Ad/Ünvan
    private String name;

    // Vergi numarası
    private String taxNumber;

    // Hesap para birimi
    @ManyToOne
    private Currency currency;

    // Adres bilgisi
    private String address;

    public enum CustomerVendorType {
        CUSTOMER, VENDOR, BOTH
    }
}
