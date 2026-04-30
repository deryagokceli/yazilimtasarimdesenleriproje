package com.akinciteknik.servis.repository;

import com.akinciteknik.servis.model.Yorum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YorumRepository extends JpaRepository<Yorum, Long> {
}