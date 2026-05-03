package com.akinciteknik.servis.service.observer;

import com.akinciteknik.servis.model.Randevu;
import org.springframework.stereotype.Component;

@Component
public class AdminPanelObserver implements RandevuObserver {
    @Override
    public void guncelle(Randevu randevu) {
        System.out.println("ADMİN BİLDİRİM: Randevu tamamlandı. -> ID: " + randevu.getId());
    }
}
