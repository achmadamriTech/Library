package com.example.library.service;

import java.util.List;
import java.util.Optional;

import com.example.library.repository.SewaDetailRepository;
import com.example.library.repository.SewaRepository;
import com.example.library.entity.SewaDetail;
import com.example.library.entity.Sewa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SewaDetailService {
    @Autowired
    private SewaDetailRepository sewaDetailRepository;
    @Autowired
    private SewaRepository sewaRepository;

    // Get All Data Detail
    public List<SewaDetail> getAllSewaDetails() {
        if (sewaDetailRepository.getAllSewaDetail().isEmpty()) {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sewa tidak ada");
        }
        return sewaDetailRepository.getAllSewaDetail();
    }

    // Get All Data Sewa
    public List<Sewa> getAllSewa(){
        return sewaRepository.getAllSewa();
    }

    // Get Data By ID
    public Optional<SewaDetail> getSewaDetailById(Long sewaId) {
        Optional<SewaDetail> result = sewaDetailRepository.getSewaDetailById(sewaId);
        
        if (result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Sewa tidak ada!");
        }
        return result;
    }

     // Insert Data Service
     public void createSewa(Sewa sewa) {
        Optional<Sewa> sewaOptional = sewaRepository.findByID(sewa.getID());

        if (sewaOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Data Sewa Sudah Ada");
        }
        else {
            sewaRepository.save(sewa);
            throw new ResponseStatusException(HttpStatus.OK, "Data Sewa Berhasil Di Tambah");
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
