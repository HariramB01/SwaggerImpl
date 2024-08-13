package com.concert.Service;

import com.concert.Entity.Concert;
import com.concert.Exception.ResourceNotFoundException;
import com.concert.Repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConcertService {

    @Autowired
    private ConcertRepository concertRepository;

    public List<Concert> searchConcerts(String artist, String venue, LocalDateTime dateTime) {
        return concertRepository.findByArtistOrVenueOrDateTime(artist, venue, dateTime);
    }

    public Concert getConcertById(Long concertId) {
        return concertRepository.findById(concertId)
                .orElseThrow(() -> new ResourceNotFoundException("Concert not found"));
    }

    public Concert createConcert(Concert concert) {
        // Add any additional logic if needed, e.g., validation
        return concertRepository.save(concert);
    }

    public List<Concert> getAllConcerts() {
        return concertRepository.findAll();
    }
}
