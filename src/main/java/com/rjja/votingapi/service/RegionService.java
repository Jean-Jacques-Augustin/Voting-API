package com.rjja.votingapi.service;

import com.rjja.votingapi.models.Region;
import com.rjja.votingapi.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    private final RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }

    public Region getRegionById(Long regionId) {
        return regionRepository.findById(regionId).orElse(null);
    }

    public void addNewRegion(Region region) {
        // find if region exists
        Region regionExists = regionRepository.findRegionByName(region.getName());
        if (regionExists != null) {
            throw new IllegalStateException("Region already exists");
        }
        regionRepository.save(region);
    }

    public void deleteRegion(Long regionId) {
        boolean exists = regionRepository.existsById(regionId);
        if (!exists) {
            throw new IllegalStateException("Region with id " + regionId + " does not exist");
        }
        regionRepository.deleteById(regionId);
    }

    public void updateRegion(Long regionId, String name, String description) {
        boolean exists = regionRepository.existsById(regionId);
        if (!exists) {
            throw new IllegalStateException("Region with id " + regionId + " does not exist");
        }
        Region region = regionRepository.findById(regionId).orElse(null);
        if (name != null && name.length() > 0 && !region.getName().equals(name)) {
            region.setName(name);
        }
        if (description != null && description.length() > 0 && !region.getDescription().equals(description)) {
            region.setDescription(description);
        }
        regionRepository.save(region);

    }
}
