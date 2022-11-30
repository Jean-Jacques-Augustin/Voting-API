package com.rjja.votingapi.service;

import com.rjja.votingapi.models.Bv;
import com.rjja.votingapi.repository.BvRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BvService {
    private final BvRepository bvRepository;

    public BvService(BvRepository bvRepository) {
        this.bvRepository = bvRepository;
    }

    public List<Bv> getBv() {
        return bvRepository.findAll();
    }

    public Bv getBvById(Long bvId) {
        return bvRepository.findById(bvId).orElse(null);
    }

    public Bv getBvByCommune(String bvCommune) {
        return bvRepository.findByCommune(bvCommune);
    }


    public void createBv(Bv bv) {
        // exist bv
        if (bvRepository.findByName(bv.getName()) != null) {
            throw new IllegalStateException("bv name taken");
        }

        bvRepository.save(bv);
    }


    public void deleteBv(Long bvId) {
        boolean exists = bvRepository.existsById(bvId);
        if (!exists) {
            throw new IllegalStateException("bv with id " + bvId + " does not exists");
        }

        bvRepository.deleteById(bvId);
    }
}
