package com.akinciteknik.servis.service.observer;

import com.akinciteknik.servis.model.Randevu;
import com.akinciteknik.servis.service.notification.NotificationService;
import org.springframework.stereotype.Component;

@Component
public class MusteriPanelObserver implements RandevuObserver {

    private final NotificationService notificationService;

    public MusteriPanelObserver(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void guncelle(Randevu randevu) {

        System.out.println(
                "Müşteri paneli güncellendi: Randevu tamamlandı → ID: "
                        + randevu.getId()
        );

        notificationService.notifyClients(
                "Randevu #" + randevu.getId() + " tamamlandı."
        );
    }
}