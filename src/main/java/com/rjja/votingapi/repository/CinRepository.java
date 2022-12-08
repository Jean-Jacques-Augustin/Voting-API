package com.rjja.votingapi.repository;

import com.rjja.votingapi.entity.Cin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CinRepository extends JpaRepository<Cin, Long> {
    @Query("select (count(c) > 0) from Cin c where c.num_cin = ?1")
    boolean existsByNum_cin(Long num_cin);
}
