package com.example.library.repository;

import java.util.List;
import java.util.Optional;

import com.example.library.entity.Sewa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SewaRepository extends JpaRepository<Sewa, Long> {
    
    Optional<Sewa> findByID(Long ID);

    @Query(value =
    "SELECT "
    + " s.id, s.tglsewa, s.lamasewa, s.keterangan, "
    + " s.isbn, b.judul, b.pengarang, "
    + " s.pelangganid, p.kodepel, p.nama, p.telp, p.email "
    + "FROM Sewa s "
    + "INNER JOIN Pelanggan p ON s.pelangganid=p.id "
    + "INNER JOIN Buku b ON s.isbn=b.isbn "
    , nativeQuery = true)
    public List<Sewa> getAllSewa();
}
