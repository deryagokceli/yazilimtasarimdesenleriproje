package com.akinciteknik.servis.repository;

import com.akinciteknik.servis.model.Randevu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RandevuRepository extends JpaRepository<Randevu, Long> {
}