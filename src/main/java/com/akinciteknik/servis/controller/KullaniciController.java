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
@CrossOrigin(origins = "*")
public class KullaniciController {

    private final KullaniciRepository kullaniciRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Kullanici loginVerisi) {
        // Email üzerinden kullanıcıyı bulalım
        Optional<Kullanici> kullanici = kullaniciRepository.findAll().stream()
                .filter(k -> k.getEmail().equals(loginVerisi.getEmail()) &&
                        k.getSifre().equals(loginVerisi.getSifre()))
                .findFirst();

        if (kullanici.isPresent()) {
            return ResponseEntity.ok(kullanici.get()); // Giriş başarılı
        } else {
            return ResponseEntity.status(401).body("Email veya şifre hatalı!");
        }
    }
}