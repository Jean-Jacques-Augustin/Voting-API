package com.rjja.votingapi.repository;

import com.rjja.votingapi.models.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommuneRepository extends JpaRepository<Commune, Long> {

    @Query("SELECT c FROM Commune c WHERE c.code_cin = ?1")
    Commune findCommuneByName(String name);
}
