package com.example.library.repository;

// import java.util.Optional;
import java.util.List;

import com.example.library.entity.SewaDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SewaDetailRepository extends JpaRepository<SewaDetail, Long> {
    
    @Query(value =
        "SELECT "
        + " S.ID, S.TGLSEWA, S.LAMASEWA, S.KETERANGAN "
        + " S.ISBN, B.JUDUL, B.PENGARANG "
        + " S.PELANGGANID, P.KODEPEL, P.NAMA, P.TELP, P.EMAIL "
        + " FROM SEWA S "
        + " INNER JOIN PELANGGAN ON S.PELANGGANID=PELANGGAN.ID "
        + " INNER JOIN BUKU ON S.ISBN=B.ISBN "
        , nativeQuery = true)
        List<SewaDetail> getSewaDetail();

    // @Query(value =
    //     "SELECT "
    //     + " S.ID, S.TGLSEWA, S.LAMASEWA, S.KETERANGAN "
    //     + " S.ISBN, B.JUDUL, B.PENGARANG "
    //     + " S.PELANGGANID, P.KODEPEL, P.NAMA, P.TELP, P.EMAIL "
    //     + " FROM SEWA S "
    //     + " INNER JOIN PELANGGAN ON S.PELANGGANID=PELANGGAN.ID "
    //     + " INNER JOIN BUKU ON S.ISBN=B.ISBN "
    //     + " WHERE S.ID=:SewaId"
    //     , nativeQuery = true)
    //     Optional<SewaDetail> getSewaDetailById(@Param("sewaId") Long sewaId);
}
