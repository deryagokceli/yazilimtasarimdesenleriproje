package com.akinciteknik.servis.service;

import com.akinciteknik.servis.config.DatabaseManager;
import com.akinciteknik.servis.model.Randevu;
import com.akinciteknik.servis.model.Parca;
import com.akinciteknik.servis.repository.RandevuRepository;
import com.akinciteknik.servis.repository.ParcaRepository;
import com.akinciteknik.servis.service.strategy.FiyatHesaplamaStratejisi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;
import com.akinciteknik.servis.service.observer.RandevuObserver;
import com.akinciteknik.servis.dto.ServisTalepRequest;
import com.akinciteknik.servis.model.Kullanici;
import com.akinciteknik.servis.repository.KullaniciRepository;

@Service
@RequiredArgsConstructor
public class ServisYonetimFacade {

    private final RandevuRepository randevuRepository;
    private final ParcaRepository parcaRepository;
    private final StratejiFabrikasi stratejiFabrikasi;
    private final List<RandevuObserver> observerlar;
    private final KullaniciRepository kullaniciRepository;



    @Transactional
    public Randevu servisKaydiOlustur(Randevu randevu, Long parcaId, Double saat, String stratejiTipi) {

        DatabaseManager.getInstance().baglantiKontrol();

        // 1. Parçayı bulalım
        Parca parca = parcaRepository.findById(parcaId)
                .orElseThrow(() -> new RuntimeException("Parça bulunamadı"));

        // 2. Strateji seçelim ve hesaplayalım
        FiyatHesaplamaStratejisi strateji = stratejiFabrikasi.stratejiGetir(stratejiTipi);
        System.out.println("Aktif strateji: " + strateji.getClass().getSimpleName());
        BigDecimal toplam = strateji.hesapla(parca.getBirimFiyat(), saat);

        // 3. Şeffaflık Verilerini Ayrıştıralım
        // Parça ücretini doğrudan parçadan alıyoruz
        double parcaMaliyeti = parca.getBirimFiyat().doubleValue();

        // İşçilik ücreti saatlik servis bedeline göre hesaplanır
        double iscilikMaliyeti = saat * 500;

        // 4. Randevu Nesnesini Detaylıca Güncelleyelim
        randevu.setParcaUcreti(parcaMaliyeti);
        randevu.setIscilikUcreti(iscilikMaliyeti);
        randevu.setToplamTutar(toplam.doubleValue());

        // Müşteriye gösterilecek servis notunu mevcut açıklamadan alalım
        if (randevu.getServisNotu() == null || randevu.getServisNotu().isEmpty()) {
            randevu.setServisNotu(randevu.getArizaAciklamasi());
        }

        // 5. Kaydedelim
        return randevuRepository.save(randevu);

    }
    @Transactional
    public Randevu randevuDurumuGuncelle(Long randevuId, String yeniDurum) {
        Randevu randevu = randevuRepository.findById(randevuId)
                .orElseThrow(() -> new RuntimeException("Randevu bulunamadı"));

        randevu.setDurum(yeniDurum);
        Randevu kaydedilenRandevu = randevuRepository.save(randevu);

        if ("TAMAMLANDI".equalsIgnoreCase(yeniDurum)) {
            observerlar.forEach(observer -> observer.guncelle(kaydedilenRandevu));
        }

        return kaydedilenRandevu;
    }
    @Transactional
    public Randevu servisTalebiOlustur(ServisTalepRequest request) {

        Kullanici musteri = kullaniciRepository.findByEmail(request.getEmail())
                .orElseGet(() -> {
                    Kullanici yeniMusteri = new Kullanici();
                    yeniMusteri.setAd(request.getAd());
                    yeniMusteri.setSoyad(request.getSoyad());
                    yeniMusteri.setEmail(request.getEmail());
                    yeniMusteri.setSifre("123456");
                    yeniMusteri.setRol("MUSTERI");
                    return kullaniciRepository.save(yeniMusteri);
                });

        Randevu randevu = new Randevu();
        randevu.setMusteri(musteri);
        randevu.setCihazMarka(request.getCihazMarka());
        randevu.setCihazModel(request.getCihazModel());
        randevu.setArizaAciklamasi(request.getArizaAciklamasi());
        randevu.setDurum("BEKLEMEDE");

        return servisKaydiOlustur(
                randevu,
                request.getParcaId(),
                request.getSaat(),
                request.getStratejiTipi()
        );
    }
    public List<Randevu> getMusteriRandevulari(Long musteriId) {
        return randevuRepository.findByMusteriId(musteriId);
    }
    public List<Randevu> tumRandevulariGetir() {
        return randevuRepository.findAll();
    }
}