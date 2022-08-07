package com.example.demo.vandalism;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VandalismRepository extends JpaRepository<Vandalism,Long> {


    @Query("SELECT v FROM Vandalism v WHERE v.lat = ?1 AND v.lon = ?1")
Optional<Vandalism> findVandalismByLatLon(Double lat,Double lon);

    @Query("SELECT v FROM Vandalism v WHERE v.cleaned = ?1")
    Optional<Vandalism> findVandalismByCleaned(Boolean cleaned);

}
