package com.example.library.controller;

import java.util.List;
import com.example.library.entity.Buku;
import com.example.library.service.BukuService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/buku")
public class BukuController {
    
    // Variable dari service
    private BukuService bukuService;

    public BukuController(BukuService bukuService) {
        this.bukuService = bukuService;
    }

    // Menampilkkan Data Buku Keseluruhan
    @GetMapping("")
    public List<Buku> getAllBuku() {
        return bukuService.getAllBuku();
    }

    // Menampilkan Data buku By Id
    @GetMapping("/{bukuId}")
    public Buku getBukuById(@PathVariable(name="bukuId") Long bukuId){
        return bukuService.getBukuById(bukuId);
    }

     // Menampilkan Data buku By Judul
     @GetMapping("/judul/{judul}")
     public List<Buku> getBukuByJudul(@PathVariable(name="judul") String judul){
         return bukuService.getBukuByJudul(judul);
     }

     @GetMapping("/pengarang/{pengarang}")
     public List<Buku> getBukuByPengarang(@PathVariable(name="pengarang") String pengarang){
         return bukuService.getBukuByPengarang(pengarang);
     }

    //  Input Data 
     @PostMapping("")
     public void createBuku(@RequestBody final Buku buku){
         bukuService.createBuku(buku);
     }

    //  Delete Data
     @DeleteMapping("/{bukuId}")
         public void deleteBuku(@PathVariable final Long bukuId){
            bukuService.deleteBuku(bukuId);
     }

    //  Edit Data
    @PutMapping("/{bukuId}")
    public void editBuku(@PathVariable final Long bukuId, @RequestBody final Buku buku) {
        bukuService.editBuku(bukuId, buku);
    }
}
