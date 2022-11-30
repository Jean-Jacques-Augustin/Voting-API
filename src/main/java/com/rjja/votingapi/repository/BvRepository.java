package com.rjja.votingapi.repository;

import com.rjja.votingapi.models.Bv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BvRepository extends JpaRepository<Bv, Long> {

    @Query("SELECT b FROM Bv b WHERE b.commune = ?1")
    Bv findByCommune(String bvCommune);

    @Query("SELECT b FROM Bv b WHERE b.name = ?1")
    Bv findByName(String bvName);
}
