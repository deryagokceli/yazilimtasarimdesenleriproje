package com.akinciteknik.servis.service.strategy;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class StandartFiyatStratejisi implements FiyatHesaplamaStratejisi {
    @Override
    public BigDecimal hesapla(BigDecimal parcaFiyati, Double iscilikSaati) {
        BigDecimal iscilikUcreti = BigDecimal.valueOf(iscilikSaati * 500); // Saatlik 500 TL
        return parcaFiyati.add(iscilikUcreti);
    }
}