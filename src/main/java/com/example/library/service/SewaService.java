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
        Optional<SewaDetail> sewaDetailOptional = sewaDetailRepository.findById(sewaId);

        if (sewaDetailOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Sewa Tidak Ada!");
        }
        return sewaDetailOptional.get();
    }


}
