package com.example.library.service;

import java.util.List;
import java.util.Optional;

import com.example.library.entity.Pelanggan;
import com.example.library.repository.PelangganRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PelangganService {
    @Autowired
    private PelangganRepository pelangganRepository;

    // Get Semua Data
    public List<Pelanggan> getAllPelanggan(){
        return pelangganRepository.findAll();
    }

    // Ambil data Berdasarkan ID
    public Pelanggan getPelangganById(Long pelangganId){
        Optional<Pelanggan> pelanggan = pelangganRepository.findByID(pelangganId);

        if (pelanggan.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data tidak Ditemukan!");
        }
        return pelanggan.get();
    }

    // Insert Data
    public void createPelanggan(Pelanggan pelanggan){
        Optional<Pelanggan> pelangganOptional = pelangganRepository.findByID(pelanggan.getID());

        if (pelangganOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Data Sudah Ada");
        } else {
            pelangganRepository.save(pelanggan);
            throw new ResponseStatusException(HttpStatus.OK,"Data Berhasil di Input!");
        }
    }

    // Update Data
    public void editPelanggan(Long pelangganId, Pelanggan pelanggan){
        Optional<Pelanggan> pelangganOptional = pelangganRepository.findByID(pelangganId);
        
        if (pelangganOptional.isPresent()) {
            pelangganRepository.save(pelanggan);
            throw new ResponseStatusException(HttpStatus.OK,"Data berhasil Diubah");
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Data Tidak Ditemukan!");
        }
    }
    
    // Delete Data
    public void deletePelanggan(Long pelangganId){
        Optional<Pelanggan> pelangganOptional = pelangganRepository.findByID(pelangganId);

        if (pelangganOptional.isPresent()) {
            pelangganRepository.deleteById(pelangganId);
            throw new ResponseStatusException(HttpStatus.OK,"Data Berhasil Di hapus!");
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT," Data Tidak Ditemukan!");
        }
    }

    // Ambil Data berdasarkan nama
    public List<Pelanggan> getPelangganByNama(String nama){
        List<Pelanggan> pelanggan = pelangganRepository.findByNAMAIgnoreCase(nama); 
        
        if(pelanggan.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nama Tidak Ditemukan");
        }
        return pelanggan;
    }
}
