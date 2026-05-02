package com.akinciteknik.servis.repository;
import java.util.Optional;
import com.akinciteknik.servis.model.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KullaniciRepository extends JpaRepository<Kullanici, Long> {
    Optional<Kullanici> findByEmailAndSifre(String email, String sifre);

}