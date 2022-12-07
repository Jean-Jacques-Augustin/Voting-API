package com.rjja.votingapi.service;

import com.rjja.votingapi.entity.Cin;
import com.rjja.votingapi.repository.CinRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CinService {
    private final CinRepository cinRepository;

    public CinService(CinRepository cinRepository) {
        this.cinRepository = cinRepository;
    }

    public void getAllCin() {
        cinRepository.findAll();
    }

    public void getCinById(Long id) {
        cinRepository.findById(id).orElseThrow();
    }


    public void createCin(Cin cin) {
        // check if number already exists
        if (cinRepository.existsByNum_cin(cin.getNum_cin())) {
            throw new IllegalStateException("CIN already exists");
        }
        cinRepository.save(cin);
    }

    @Transactional
    public void updateCin(Long id, Cin cin) {
        // check if number already exists
        boolean exists = cinRepository.existsByNum_cin(cin.getNum_cin());
        if (exists) {
            throw new IllegalStateException("CIN already exists");
        }
        Cin cinToUpdate = cinRepository.findById(id).orElseThrow();
        cinToUpdate.setNum_cin(cin.getNum_cin());
        cinRepository.save(cinToUpdate);
    }

    public void deleteCin(Long id) {
// check if number exists
        boolean exists = cinRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("CIN does not exist");
        }
        cinRepository.deleteById(id);
    }
}
