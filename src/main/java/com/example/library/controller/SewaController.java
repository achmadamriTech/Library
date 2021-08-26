package com.example.library.controller;

import com.example.library.service.SewaService;
import com.example.library.entity.Sewa;
import com.example.library.entity.SewaDetail;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/sewa")
public class SewaController {
    
    private SewaService sewaService;

    // Constructor
    public SewaController(SewaService sewaService) {
        this.sewaService = sewaService;
    }

    // Get Semua Data Sewa
    @GetMapping("/")
    public List<Sewa> getAllSewa(){
        return sewaService.getAllSewa();
    }

    // Get Data Berdasarkan ID Sewa
    @GetMapping("/{sewaId}")
    public Sewa get(@PathVariable Long sewaId){
        return sewaService.getAllSewaById(sewaId);
    }

    // Get Semua Data SewaDetail
    @GetMapping("/detail/")
    public List<SewaDetail> getAllSewaDetail(){
        return sewaService.getAllSewaDetail();
    }

    // Get Data Berdasarkan SewaDetailById
    @GetMapping("/detail/{sewaId}")
    public SewaDetail getSewaDetailById (@PathVariable Long sewaId) {
        return sewaService.getSewaDetailById(sewaId);
    }

    @PostMapping("")
    public void createSewa(@RequestBody final Sewa sewa ){
        sewaService.createSewa(sewa);
    }
    
    
}
