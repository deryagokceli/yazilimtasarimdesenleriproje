package com.akinciteknik.servis.service.command;

import com.akinciteknik.servis.service.ServisYonetimFacade;

public class RandevuDurumGuncelleCommand implements RandevuCommand {

    private final ServisYonetimFacade facade;
    private final Long randevuId;
    private final String durum;

    public RandevuDurumGuncelleCommand(ServisYonetimFacade facade, Long randevuId, String durum) {
        this.facade = facade;
        this.randevuId = randevuId;
        this.durum = durum;
    }

    @Override
    public void execute() {
        facade.randevuDurumuGuncelle(randevuId, durum);
    }
}