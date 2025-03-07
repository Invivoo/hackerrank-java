package com.invivoo.hackerrank.controller;


import com.invivoo.hackerrank.entity.Artist;
import com.invivoo.hackerrank.service.ArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        Optional<Artist> optionalArtiste = artistService.getArtistById(id);
        return optionalArtiste.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/between-dates")
    public ResponseEntity<List<Artist>> getArtistsBornBetween(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate) {

        List<Artist> artists = artistService.getArtistsBornBetween(
                LocalDate.parse(startDate),
                LocalDate.parse(endDate)
        );

        return ResponseEntity.ok(artists);
    }

    @PostMapping
    public ResponseEntity<Artist> saveArtist(@RequestBody Artist artist) {
        Artist savedArtist = artistService.saveArtist(artist);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArtist);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Artist> delete(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        try {
            artistService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }
}