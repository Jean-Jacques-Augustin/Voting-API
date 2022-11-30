package com.rjja.votingapi.service;

import com.rjja.votingapi.models.Commune;
import com.rjja.votingapi.repository.CommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommuneService {
    private final CommuneRepository communeRepository;

    @Autowired
    public CommuneService(CommuneRepository communeRepository) {
        this.communeRepository = communeRepository;
    }

    public List<Commune> getCommune() {
        return communeRepository.findAll();
    }

    public Commune getCommuneById(Long id) {
        return communeRepository.findById(id).orElse(null);
    }

    public Commune getCommuneByName(String name) {
        return communeRepository.findCommuneByName(name);
    }

    public void createCommune(Commune commune) {
        // find if commune exists
        Commune communeExists = communeRepository.findCommuneByName(commune.getName());
        if (communeExists != null) {
            throw new IllegalStateException("Commune already exists");
        }
        communeRepository.save(commune);
    }


    public void deleteCommune(Long id) {
        // find if commune exists
        Commune commune = communeRepository.findById(id).orElse(null);
        if (commune == null) {
            throw new IllegalStateException("Commune does not exist");
        }
        communeRepository.deleteById(id);
    }
}
