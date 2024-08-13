package com.concert.Controller;

import com.concert.Entity.Concert;
import com.concert.Service.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/concerts")
public class ConcertController {

    @Autowired
    private ConcertService concertService;

    @GetMapping("/all")
    public ResponseEntity<List<Concert>> getAllConcerts() {
        List<Concert> concerts = concertService.getAllConcerts();
        return ResponseEntity.ok(concerts);
    }

    @GetMapping
    public ResponseEntity<List<Concert>> searchConcerts(@RequestParam(required = false) String artist,
                                                        @RequestParam(required = false) String venue,
                                                        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime) {
        List<Concert> concerts = concertService.searchConcerts(artist, venue, dateTime);
        return ResponseEntity.ok(concerts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Concert> getConcertById(@PathVariable Long id) {
        Concert concert = concertService.getConcertById(id);
        return ResponseEntity.ok(concert);
    }

    @PostMapping
    public ResponseEntity<Concert> createConcert(@RequestBody Concert concert) {
        Concert createdConcert = concertService.createConcert(concert);
        return ResponseEntity.status(201).body(createdConcert);
    }

    // Other endpoints...
}
