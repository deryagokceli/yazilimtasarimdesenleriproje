package com.akinciteknik.servis.service.observer;

import com.akinciteknik.servis.model.Randevu;
import org.springframework.stereotype.Component;

@Component
public class MusteriPanelObserver implements RandevuObserver {

    @Override
    public void guncelle(Randevu randevu) {
        System.out.println("MÜŞTERİ BİLDİRİM: Servisiniz tamamlandı.");
    }
}
