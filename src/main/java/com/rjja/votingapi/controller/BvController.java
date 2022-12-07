package com.rjja.votingapi.controller;


import com.rjja.votingapi.entity.Bv;
import com.rjja.votingapi.service.BvService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bv")
public class BvController {

    private final BvService bvService;

    public BvController(BvService bvService) {
        this.bvService = bvService;
    }

    /**
     * CRUD
     */

    // Get all BV
    @GetMapping
    public List<Bv> getAllBv() {
        return bvService.getAllBv();
    }

    // Get BV by ID

    @GetMapping("/{id}")
    public Bv getBvById(@PathVariable Long id) {
        return bvService.getBvById(id);
    }

    // Create BV

    @PostMapping
    public Bv createBv(@RequestBody Bv bv) {
        return bvService.createBv(bv);
    }

    // Update BV

    @PutMapping("/{id}")
    public Bv updateBv(@PathVariable Long id, @RequestBody Bv bv) {
        return bvService.updateBv(id, bv);
    }

    // Delete BV
    @DeleteMapping("/{id}")
    public void deleteBv(@PathVariable Long id) {
        bvService.deleteBv(id);
    }
}
