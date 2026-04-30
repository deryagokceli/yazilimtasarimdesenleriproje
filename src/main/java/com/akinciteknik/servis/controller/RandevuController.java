package com.akinciteknik.servis.controller;

import com.akinciteknik.servis.model.Randevu;
import com.akinciteknik.servis.service.ServisYonetimFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/randevular")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Vue.js bağlantısı için gerekli
public class RandevuController {

    private final ServisYonetimFacade servisYonetimFacade;

    @PostMapping("/olustur")
    public ResponseEntity<Randevu> randevuAl(
            @RequestBody Randevu randevu,
            @RequestParam Long parcaId,
            @RequestParam Double saat,
            @RequestParam String stratejiTipi) {

        Randevu yeniRandevu = servisYonetimFacade.servisKaydiOlustur(randevu, parcaId, saat, stratejiTipi);
        return ResponseEntity.ok(yeniRandevu);
    }
}