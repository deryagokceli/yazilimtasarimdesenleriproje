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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "musteri_id")
    private Kullanici musteri;

    private String cihazMarka;
    private String cihazModel;
    private String arizaAciklamasi;
    private String durum = "BEKLEMEDE";
    private Double toplamTutar;
    private LocalDateTime olusturmaTarihi = LocalDateTime.now();
}