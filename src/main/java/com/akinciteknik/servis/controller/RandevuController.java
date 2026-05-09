package com.akinciteknik.servis.controller;

import com.akinciteknik.servis.model.Randevu;
import com.akinciteknik.servis.service.ServisYonetimFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.akinciteknik.servis.service.command.RandevuCommand;
import com.akinciteknik.servis.service.command.RandevuDurumGuncelleCommand;
import com.akinciteknik.servis.dto.ServisTalepRequest;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/randevular")
@RequiredArgsConstructor
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
    // Müşteri paneli için eklenen liste metodu
    @GetMapping("/musteri/{musteriId}")
    public ResponseEntity<List<Randevu>> getRandevularByMusteri(@PathVariable Long musteriId) {
        // Facade üzerinden verileri çekiyoruz
        List<Randevu> liste = servisYonetimFacade.getMusteriRandevulari(musteriId);
        return ResponseEntity.ok(liste);
    }
    @PutMapping("/{id}/durum")
    public ResponseEntity<?> randevuDurumGuncelle(
            @PathVariable Long id,
            @RequestParam String durum) {

        try {

            RandevuCommand command =
                    new RandevuDurumGuncelleCommand(servisYonetimFacade, id, durum);

            command.execute();

            return ResponseEntity.ok("Durum güncellendi");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/servis-talebi")
    public ResponseEntity<?> servisTalebiOlustur(@RequestBody ServisTalepRequest request) {
        try {
            Randevu randevu = servisYonetimFacade.servisTalebiOlustur(request);
            return ResponseEntity.ok(randevu);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Randevu>> tumRandevulariGetir() {
        List<Randevu> liste = servisYonetimFacade.tumRandevulariGetir();
        return ResponseEntity.ok(liste);
    }

}
