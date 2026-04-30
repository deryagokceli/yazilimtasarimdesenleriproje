package com.akinciteknik.servis.service.strategy;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class IndirimliFiyatStratejisi implements FiyatHesaplamaStratejisi {
    @Override
    public BigDecimal hesapla(BigDecimal parcaFiyati, Double iscilikSaati) {
        BigDecimal standart = parcaFiyati.add(BigDecimal.valueOf(iscilikSaati * 500));
        return standart.multiply(BigDecimal.valueOf(0.9)); // %10 İndirim
    }
}
