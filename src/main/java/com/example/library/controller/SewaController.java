package com.example.library.controller;

import com.example.library.entity.SewaDetail;
import com.example.library.entity.Sewa;

import java.util.List;
import java.util.Optional;

import com.example.library.service.SewaDetailService;

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
@RequestMapping("/sewa")
public class SewaController {
    private SewaDetailService sewaDetailService;

    // Constructor
    public SewaController(SewaDetailService sewaDetailService) {
        this.sewaDetailService = sewaDetailService;
    }

    // Get All Data
    @GetMapping("/")
    public List<Sewa> getAllSewa() {
        return sewaDetailService.getAllSewa();
    }

    // Get All Data Detail
    @GetMapping("/detail")
    public List<SewaDetail> getAllSewaDetails() {
        return sewaDetailService.getAllSewaDetails();
    }

    // Get By Id
    @GetMapping("/detail/{sewaId}")
    public Optional<SewaDetail> getSewaDetailById (@PathVariable final Long sewaId) {
        return sewaDetailService.getSewaDetailById(sewaId);
    }

    // Insert Data
    @PostMapping("")
    public void createSewa(@RequestBody final Sewa sewa ){
        sewaDetailService.createSewa(sewa);
    }

     //  Delete Data
     @DeleteMapping("/{sewaId}")
     public void deleteSewa(@PathVariable final Long sewaId){
        sewaDetailService.deleteSewa(sewaId);
    }
    
    // Update Data
    @PutMapping("/{sewaId}")
    public void editSewa(@PathVariable final Long sewaId, @RequestBody final Sewa sewa) {
        sewaDetailService.editSewa(sewaId, sewa);
    }

}
