package com.rjja.votingapi.repository;

import com.rjja.votingapi.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long>, JpaSpecificationExecutor<Region> {

    @Query("SELECT r FROM Region r WHERE r.name = ?1")
    Region findRegionByName(String name);
}
