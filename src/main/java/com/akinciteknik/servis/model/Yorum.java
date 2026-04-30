package com.akinciteknik.servis.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Yorumlar")
@Getter @Setter
public class Yorum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "RandevuId")
    private Randevu randevu;

    @Column(name = "Puan")
    private Integer puan;

    @Column(name = "YorumMetni")
    private String yorumMetni;
}