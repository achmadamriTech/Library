package com.example.library.service;

import java.util.List;
// import java.util.Optional;

import com.example.library.entity.SewaDetail;
import com.example.library.repository.SewaDetailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SewaDetailService {
    @Autowired
    private SewaDetailRepository sewaDetailRepository;

    // public SewaDetail getSewaDetailById(Long sewaId){
    //     Optional<SewaDetail> sewaDetail = sewaDetailRepository.getSewaDetailById(sewaId);
        
    //     if (sewaDetail.isEmpty()) {
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Matching Sewa Detail Was Found!");
    //     }
    //     return sewaDetail.get();
    // }

    public List<SewaDetail> getSewaDetail() {
        List<SewaDetail> sewaDetail = sewaDetailRepository.getSewaDetail();

        if (sewaDetail.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Matching Sewa Detail Was Found!");
        }
        return sewaDetail;
    }
}
