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
    @Column(name = "Id")
    private Long id;

    @Column(name = "Ad") // Veritabanındaki adı 'Ad' ise bu şart
    private String ad;

    @Column(name = "Soyad")
    private String soyad;

    @Column(name = "Email", unique = true)
    private String email;

    @Column(name = "Sifre")
    private String sifre;

    @Column(name = "Rol")
    private String rol;
}