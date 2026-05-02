package com.akinciteknik.servis.repository;

import com.akinciteknik.servis.model.Randevu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RandevuRepository extends JpaRepository<Randevu, Long> {
    // Müşteri ID'sine göre randevuları listeleyen o sihirli satır:
    List<Randevu> findByMusteriId(Long musteriId);
}
