package com.invivoo.hackerrank.service;


import com.invivoo.hackerrank.entity.Artist;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ArtistService {
    Optional<Artist> getArtistById(Long id);

    void delete(Long id);

    Artist saveArtist(Artist artist);

    List<Artist> getArtistsBornBetween(LocalDate startDate, LocalDate endDate);

}
