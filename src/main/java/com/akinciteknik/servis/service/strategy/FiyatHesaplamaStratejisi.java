package com.akinciteknik.servis.service.strategy;

import java.math.BigDecimal;

public interface FiyatHesaplamaStratejisi {
    BigDecimal hesapla(BigDecimal parcaFiyati, Double iscilikSaati);
}
