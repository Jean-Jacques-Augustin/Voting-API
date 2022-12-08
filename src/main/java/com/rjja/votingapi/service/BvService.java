package com.rjja.votingapi.service;

import com.rjja.votingapi.entity.Bv;
import com.rjja.votingapi.repository.BvRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BvService {
    private final BvRepository bvRepository;

    public BvService(BvRepository bvRepository) {
        this.bvRepository = bvRepository;
    }

    public List<Bv> getAllBv() {
        return bvRepository.findAll();
    }

    public Bv getBvById(Long id) {
        return bvRepository.findById(id).orElseThrow();
    }

    public Bv createBv(Bv bv) {
        // check if BV already exists
        if (bvRepository.existsByName(bv.getName())) {
            throw new IllegalStateException("BV already exists");
        }
        return bvRepository.save(bv);
    }

    @Transactional
    public Bv updateBv(Long id, Bv bv) {
        // check if BV already exists
        boolean exists = bvRepository.existsByName(bv.getName());
        if (exists) {
            throw new IllegalStateException("BV already exists");
        }
        Bv bvToUpdate = bvRepository.findById(id).orElseThrow();
        bvToUpdate.setName(bv.getName());
        return bvRepository.save(bvToUpdate);
    }

    public void deleteBv(Long id) {
        // check if BV exists
        boolean exists = bvRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("BV does not exist");
        }
        bvRepository.deleteById(id);
    }
}
