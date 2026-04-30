package com.akinciteknik.servis.service;

import com.akinciteknik.servis.service.strategy.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StratejiFabrikasi {

    private final StandartFiyatStratejisi standart;
    private final IndirimliFiyatStratejisi indirimli;

    public FiyatHesaplamaStratejisi stratejiGetir(String tip) {
        if ("INDIRIMLI".equalsIgnoreCase(tip)) {
            return indirimli;
        }
        return standart; // Varsayılan
    }
}