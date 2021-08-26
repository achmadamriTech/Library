package com.example.library.service;

import com.example.library.repository.SewaRepository;
import com.example.library.entity.Sewa;

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

    // Menampilkan Seluruh Data
    public List<Sewa> getAllSewa(){
        return sewaRepository.findAll();
    }

    public Sewa getAllSewaById(Long sewaId){
        Optional<Sewa> sewaOptional = sewaRepository.findById(sewaId);

        if(sewaOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sewa tidak ada");
        } else {
            return sewaOptional.get();
        }
    }


}
