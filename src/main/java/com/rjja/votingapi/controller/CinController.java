package com.rjja.votingapi.controller;

import com.rjja.votingapi.entity.Cin;
import com.rjja.votingapi.service.CinService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cin")
public class CinController {
    private final CinService cinService;

    public CinController(CinService cinService) {
        this.cinService = cinService;
    }

    // Get all CIN

    @GetMapping
    public void getAllCin() {
        cinService.getAllCin();
    }

    // Get CIN by ID

    @GetMapping("/{id}")
    public void getCinById(@PathVariable Long id) {
        cinService.getCinById(id);
    }

    // Create CIN

    @PostMapping
    public void createCin(@RequestBody Cin cin) {
        cinService.createCin(cin);
    }

    // Update CIN

    @PutMapping("/{id}")
    public void updateCin(@PathVariable Long id, @RequestBody Cin cin) {
        cinService.updateCin(id, cin);
    }


    // Delete CIN

    @DeleteMapping("/{id}")
    public void deleteCin(@PathVariable Long id) {
        cinService.deleteCin(id);
    }

}
