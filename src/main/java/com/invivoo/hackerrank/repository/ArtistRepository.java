package com.invivoo.hackerrank.repository;

import com.invivoo.hackerrank.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    List<Artist> findAllByOrderByNameAsc();

    List<Artist> findAllByBirthDateBetweenOrderByNameAsc(LocalDate startDate, LocalDate endDate);

}
