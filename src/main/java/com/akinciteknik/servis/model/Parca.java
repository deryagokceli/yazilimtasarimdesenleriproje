package com.akinciteknik.servis.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "Parcalar")
@Getter @Setter
public class Parca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "ParcaAdi")
    private String parcaAdi;

    @Column(name = "StokAdedi")
    private Integer stokAdedi;

    @Column(name = "BirimFiyat")
    private BigDecimal birimFiyat; // SQL'deki Decimal karşılığı
}
