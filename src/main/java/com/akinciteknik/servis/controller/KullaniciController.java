package com.akinciteknik.servis.controller;

import com.akinciteknik.servis.model.Kullanici;
import com.akinciteknik.servis.repository.KullaniciRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/kullanicilar")
@RequiredArgsConstructor
public class KullaniciController {

    private final KullaniciRepository kullaniciRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Kullanici loginVerisi) {

        Optional<Kullanici> kullanici =
                kullaniciRepository.findByEmailAndSifre(
                        loginVerisi.getEmail(),
                        loginVerisi.getSifre()
                );

        if (kullanici.isPresent()) {
            return ResponseEntity.ok(kullanici.get());
        } else {
            return ResponseEntity.status(401).body("Email veya şifre hatalı!");
        }
    }
}