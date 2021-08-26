package com.example.library.service;

import com.example.library.repository.SewaDetailRepository;
import com.example.library.repository.SewaRepository;
import com.example.library.entity.Sewa;
import com.example.library.entity.SewaDetail;

import java.util.List;
import java.util.Optional;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SewaService {
    @Autowired
    private SewaRepository sewaRepository;

    @Autowired
    private SewaDetailRepository sewaDetailRepository;

    // Menampilkan Seluruh Data
    public List<Sewa> getAllSewa(){
        return sewaRepository.findAll();
    }

    // Menampilkan Data SewaDetail
    public List<SewaDetail> getAllSewaDetail(){
        if(sewaDetailRepository.getAllSewaDetail().isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Data Tidak Ditemukan!");
        }
        return sewaDetailRepository.getAllSewaDetail();
    }

    // Menampilkan Data SewaById
    public Sewa getAllSewaById(Long sewaId){
        Optional<Sewa> sewaOptional = sewaRepository.findById(sewaId);

        if(sewaOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sewa tidak ada");
        } else {
            return sewaOptional.get();
        }
    }

    public SewaDetail getSewaDetailById(Long sewaId){
        Optional<SewaDetail> sewaDetail = sewaDetailRepository.findById(sewaId);

        if (sewaDetail.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data tidak Ditemukan!");
        }
        return sewaDetail.get();
    }

    // Insert Data Service
    public void createSewa(Sewa sewa) {
        Optional<Sewa> sewaOptional = sewaRepository.findById(sewa.getID());

        if (sewaOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Sewa Sudah Ada");
        }
        else {
            sewaRepository.save(sewa);
            throw new ResponseStatusException(HttpStatus.OK, "Sewa Berhasil di Input");
        }
        
    }

    // Delete Data Sewa
    public void deleteSewa(Long sewaId) {
        Optional<Sewa> sewaOptional = sewaRepository.findById(sewaId);

        if(sewaOptional.isPresent()) {
            sewaRepository.deleteById(sewaId);
            throw new ResponseStatusException(HttpStatus.OK, "Data Sewa Berhasil Di hapus");
        }
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Sewa Tidak Ada");
    }

    // Edit Data Sewa
    public void editSewa(Long sewaId, Sewa sewa){
        Optional<Sewa> sewaOptional = sewaRepository.findById(sewaId);

        if(sewaOptional.isPresent()) {
            sewaRepository.save(sewa);
            throw new ResponseStatusException(HttpStatus.OK, "Sewa Berhasil Diubah");
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sewa Sudah Ada");
        }
    }

    public Sewa getSewaByID(Long id) {
        if (!sewaRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No matching ID was found!");
        }

        return sewaRepository.findById(id).get();
    }


}
