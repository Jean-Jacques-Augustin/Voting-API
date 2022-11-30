package com.rjja.votingapi.controller;

import com.rjja.votingapi.models.Bv;
import com.rjja.votingapi.service.BvService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bv")
public class BvController {
    private final BvService bvService;

    public BvController(BvService bvService) {
        this.bvService = bvService;
    }

    // Get all bv
    @GetMapping
    public List<Bv> getBv() {
        return bvService.getBv();
    }

    // Get bv by id
    @GetMapping(path = "{bvId}")
    public void getBvById(@PathVariable("bvId") Long bvId) {
        bvService.getBvById(bvId);
    }

    // Get bv by commune
    @GetMapping(path = "{bvCommune}")
    public void getBvByCommune(@PathVariable("bvCommune") String bvCommune) {
        bvService.getBvByCommune(bvCommune);
    }

    // post a new bv
    @GetMapping
    public void createBv(Bv bv) {
        bvService.createBv(bv);
    }

    // Update a bv
    @GetMapping(path = "{bvId}")
    public void updateBv(@PathVariable("bvId") Long bvId,
                         @RequestParam(required = false) String name,
                         @RequestParam(required = false) String commune) {
        bvService.updateBv(bvId, name, commune);
    }

    // Delete a bv
    @GetMapping(path = "{bvId}")
    public void deleteBv(@PathVariable("bvId") Long bvId) {
        bvService.deleteBv(bvId);
    }
}
