package com.akinciteknik.servis.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RandevuFiyatlandirRequest {

    private Long parcaId;

    private Double saat;

    private String stratejiTipi;

    private String servisNotu;
}