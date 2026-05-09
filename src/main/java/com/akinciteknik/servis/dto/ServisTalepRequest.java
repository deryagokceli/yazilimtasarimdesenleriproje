package com.akinciteknik.servis.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServisTalepRequest {

    private String ad;

    private String soyad;

    private String email;

    private String telefon;

    private String cihazMarka;

    private String cihazModel;

    private String arizaAciklamasi;

    private Long parcaId;

    private Double saat;

    private String stratejiTipi;
}