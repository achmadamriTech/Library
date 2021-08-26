package com.example.library.controller;

import java.util.List;

import com.example.library.entity.SewaDetail;

import com.example.library.service.SewaDetailService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sewaDetail")
public class SewaDetailController {
    
    private SewaDetailService sewaDetailService;

    // Constructor
    public SewaDetailController(SewaDetailService sewaDetailService) {
        this.sewaDetailService = sewaDetailService;
    }

    @GetMapping("/")
    public List<SewaDetail> getSewaDetail(){
        return sewaDetailService.getSewaDetail();
    }
}
