package com.example.library.controller;

import com.example.library.service.PelangganService;

import java.util.List;

import com.example.library.entity.Pelanggan;

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
@RequestMapping("/pelanggan")
public class PelangganController {
    
    private PelangganService pelangganService;

    // Constructor
    public PelangganController(PelangganService pelangganService) {
        this.pelangganService = pelangganService;
    }

    // Get Data
    @GetMapping("")
    public List<Pelanggan> getAllPelanggan(){
        return pelangganService.getAllPelanggan();
    }

    //Get Data berdasrkan ID
    @GetMapping("/{pelangganId}")
    public Pelanggan getPelangganById(@PathVariable(name="pelangganId") Long pelangganId){
        return pelangganService.getPelangganById(pelangganId);
    }

    // Insert Data
    @PostMapping("")
    public void createPelanggan(@RequestBody final Pelanggan pelanggan){
        pelangganService.createPelanggan(pelanggan);
    }

    // Delete Data
    @DeleteMapping("/{pelangganId}")
    public void deletePelanggan(@PathVariable final Long pelangganId){
        pelangganService.deletePelanggan(pelangganId);
    }

    // Update Data
    @PutMapping("/{pelangganId}")
    public void editPelanggan(@PathVariable final long pelangganId, @RequestBody final Pelanggan pelanggan){
        pelangganService.editPelanggan(pelangganId, pelanggan);
    }

    // Menampilkan pelanggan berdasarkan nama pelanggan
    @GetMapping("/nama/{nama}")
    public List<Pelanggan> getPelangganByNama(@PathVariable(name="nama") String nama){
        return pelangganService.getPelangganByNama(nama);
    }  
}
