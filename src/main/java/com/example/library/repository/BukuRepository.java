package com.example.library.repository;

import java.util.List;
import java.util.Optional;

import com.example.library.entity.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Membuat Repository untuk dipanggil ke service
@Repository
public interface BukuRepository extends JpaRepository<Buku, Long> {
    
    Optional<Buku> findByISBNIgnoreCase(String ISBN);

    // Method Custom
    List<Buku> findByJUDULContaining(String Judul);
    List<Buku> findByPENGARANGContainingIgnoreCase(String Pengarang);
}
