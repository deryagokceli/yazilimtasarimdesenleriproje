package com.akinciteknik.servis.service;

import com.akinciteknik.servis.model.Randevu;
import com.akinciteknik.servis.repository.RandevuRepository;
import com.akinciteknik.servis.repository.ParcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor //Repositoryleri içeri enjekte etmek için kullanıyoruz
public class ServisYonetimFacade {

    private final RandevuRepository randevuRepository;
    private final ParcaRepository parcaRepository;

    @Transactional
    public Randevu servisKaydiOlustur(Randevu randevu) {
        // Burada ileride Strategy deseni ile fiyat hesaplayacağız
        // Şimdilik sadece kaydediyoruz
        return randevuRepository.save(randevu);
    }
}