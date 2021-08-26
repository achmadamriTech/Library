package com.example.library.service;

import java.util.List;
import java.util.Optional;

import com.example.library.entity.Buku;
import com.example.library.repository.BukuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BukuService {
    @Autowired
    private BukuRepository bukuRepository;

    // Ambil Data semua
    public List<Buku> getAllBuku() {
        return bukuRepository.findAll(); 
    }

    // Ambil data berdasarkan Id
    public Buku getBukuById(Long bukuId){
        Optional<Buku> buku = bukuRepository.findById(bukuId);
        
        if (buku.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No matching title was found!");
        }
        return buku.get();
    }

    // Custom query menggunakan JPA
    // Startwith = query mencari field yg dimulai dengan
    // Menampilkan data berdasarkan judul
    public List<Buku> getBukuByJudul(String judul){
        List<Buku> buku = bukuRepository.findByJUDULContaining(judul); 
        
        if(buku.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No matching title was found!");
        }
        return buku;
    }

    public List<Buku> getBukuByPengarang(String pengarang){
        List<Buku> buku = bukuRepository.findByPENGARANGContainingIgnoreCase(pengarang); 
        
        if(buku.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No matching title was found!");
        }
        return buku;
    }

    public void createBuku(Buku buku) {
        Optional<Buku> bukuOptional = bukuRepository.findByISBNIgnoreCase(buku.getISBN());

        if (bukuOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "A book with same ISBN number is present!");
        }
        else {
            bukuRepository.save(buku);
            throw new ResponseStatusException(HttpStatus.OK, "Book data successfully saved!");
        }
        
    }

    public void deleteBuku(Long bukuId) {
        Optional<Buku> bukuOptional = bukuRepository.findById(bukuId);

        if(bukuOptional.isPresent()) {
            bukuRepository.deleteById(bukuId);
            throw new ResponseStatusException(HttpStatus.OK, "Book has successfully been Deleted!");
        }
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book is not available!");
    }

    public void editBuku(Long bukuId, Buku buku){
        Optional<Buku> bukuOptional = bukuRepository.findById(bukuId);

        if(bukuOptional.isPresent()) {
            bukuRepository.save(buku);
            throw new ResponseStatusException(HttpStatus.OK, "Book has successfully been Updated!");
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book is not available!");
        }
    }

    public Buku getBukuByID(Long id) {
        if (!bukuRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No matching ID was found!");
        }

        return bukuRepository.findById(id).get();
    }
}
