package com.akinciteknik.servis.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Kullanicilar")
@Getter @Setter
public class Kullanici {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ad;
    private String soyad;

    @Column(unique = true)
    private String email;

    private String sifre;
    private String rol; // ADMIN, MUSTERI, TEKNISYEN
}