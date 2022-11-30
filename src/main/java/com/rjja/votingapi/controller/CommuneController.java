package com.rjja.votingapi.controller;


import com.rjja.votingapi.models.Commune;
import com.rjja.votingapi.service.CommuneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commune")
public class CommuneController {
    private final CommuneService communeService;

    public CommuneController(CommuneService communeService) {
        this.communeService = communeService;
    }

    //Get All Commune
    @GetMapping
    public List<Commune> communeList() {
        return communeService.getCommune();
    }

    //Get commune by id
    @GetMapping("/{id}")
    public Commune getCommuneById(@PathVariable Long id) {
        return communeService.getCommuneById(id);
    }

    //Get commune by name
    @GetMapping("/{name}")
    public Commune getCommuneByName(@PathVariable String name) {
        return communeService.getCommuneByName(name);
    }

    // post a new commune
    @PostMapping
    public void createCommune(@RequestBody Commune commune) {
        communeService.createCommune(commune);
    }

    //Update a Commune
    @PutMapping("/{id}")
    public void updateCommune(@PathVariable Long id,
    				@RequestParam(required = false) String name,
    				@RequestParam(required = false) String code_cin,
    				@RequestParam(required = false) String region
    ) {
        communeService.updateCommune(id, name, code_cin, region);
    }

    //Delete a Commune
    @DeleteMapping("/{id}")
    public void deleteCommune(@PathVariable Long id) {
        communeService.deleteCommune(id);
    }


}
