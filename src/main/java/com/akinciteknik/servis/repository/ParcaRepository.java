package com.akinciteknik.servis.repository;

import com.akinciteknik.servis.model.Parca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcaRepository extends JpaRepository<Parca, Long> {
}