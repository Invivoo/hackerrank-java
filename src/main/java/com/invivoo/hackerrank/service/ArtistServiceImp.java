package com.invivoo.hackerrank.service;

import com.invivoo.hackerrank.entity.Artist;
import com.invivoo.hackerrank.repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImp implements ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistServiceImp(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public Optional<Artist> getArtistById(Long id) {
        return artistRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        artistRepository.deleteById(id);
    }

    @Override
    public Artist saveArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public List<Artist> getArtistsBornBetween(LocalDate startDate, LocalDate endDate) {
        return artistRepository.findAllByBirthDateBetweenOrderByNameAsc(startDate, endDate);
    }
}
