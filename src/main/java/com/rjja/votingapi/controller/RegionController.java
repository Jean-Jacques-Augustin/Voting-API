package com.rjja.votingapi.controller;

import com.rjja.votingapi.models.Region;
import com.rjja.votingapi.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/region")
public class RegionController {
    private final RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    // Get all regions
    @GetMapping
    public List<Region> getRegions() {
        return regionService.getAllRegions();
    }

    // Get region by id
    @GetMapping(path = "{regionId}")
    public Region getRegionById(@PathVariable("regionId") Long regionId) {
        return regionService.getRegionById(regionId);
    }

    // Add new region
    @PostMapping
    public void addNewRegion(@RequestBody Region region) {
        regionService.addNewRegion(region);
    }

    // Delete region by id
    @DeleteMapping(path = "{regionId}")
    public void deleteRegion(@PathVariable("regionId") Long regionId) {
        regionService.deleteRegion(regionId);
    }

    // Update region by id
    @PutMapping(path = "{regionId}")
    public void updateRegion(@PathVariable("regionId") Long regionId,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String description) {
        regionService.updateRegion(regionId, name, description);
    }
}
