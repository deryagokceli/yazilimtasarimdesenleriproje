package com.akinciteknik.servis.service;

import com.akinciteknik.servis.model.Randevu;
import com.akinciteknik.servis.model.Parca;//*facade fabrikayı ve stratejiyi entegre ediyoruz
import com.akinciteknik.servis.repository.RandevuRepository;
import com.akinciteknik.servis.repository.ParcaRepository;
import com.akinciteknik.servis.service.strategy.FiyatHesaplamaStratejisi;//*
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;//*

@Service
@RequiredArgsConstructor //Repositoryleri içeri enjekte etmek için kullanıyoruz
public class ServisYonetimFacade {

    private final RandevuRepository randevuRepository;
    private final ParcaRepository parcaRepository;
    private final StratejiFabrikasi stratejiFabrikasi; // FABRİKA BURAYA EKLENDİ

    @Transactional
    public Randevu servisKaydiOlustur(Randevu randevu, Long parcaId, Double saat, String stratejiTipi) {
        // 1. Parçayı bulalım
        Parca parca = parcaRepository.findById(parcaId)
                .orElseThrow(() -> new RuntimeException("Parça bulunamadı"));

        // 2. Strateji seçelim ve hesaplayalım
        FiyatHesaplamaStratejisi strateji = stratejiFabrikasi.stratejiGetir(stratejiTipi);
        BigDecimal toplam = strateji.hesapla(parca.getBirimFiyat(), saat);

        // 3. Randevuyu güncelleyip kaydedelim
        randevu.setToplamTutar(toplam.doubleValue());
        return randevuRepository.save(randevu);
    }
}