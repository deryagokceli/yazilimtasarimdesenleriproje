package com.akinciteknik.servis.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "Randevular")
@Getter @Setter
public class Randevu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MusteriId")
    private Kullanici musteri;

    @Column(name = "CihazMarka")
    private String cihazMarka;

    @Column(name = "CihazModel")
    private String cihazModel;

    @Column(name = "ArizaAciklamasi")
    private String arizaAciklamasi;

    @Column(name = "Durum")
    private String durum = "BEKLEMEDE";

    @Column(name = "ToplamTutar")
    private Double toplamTutar;

    @Column(name = "OlusturmaTarihi")
    private java.time.LocalDateTime olusturmaTarihi = java.time.LocalDateTime.now();

    //seffaflık için eklediğim yeni satırlar

    @Column(name = "ParcaUcreti")
    private Double parcaUcreti;

    @Column(name = "IscilikUcreti")
    private Double iscilikUcreti;

    @Column(name = "ServisNotu")
    private String servisNotu;
}
