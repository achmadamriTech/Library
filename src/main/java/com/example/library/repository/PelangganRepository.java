package com.example.library.repository;

import java.util.Optional;

import com.example.library.entity.Pelanggan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PelangganRepository extends JpaRepository<Pelanggan, Long> {
    
    Optional<Pelanggan> findByID(Long pelangganId);
}
