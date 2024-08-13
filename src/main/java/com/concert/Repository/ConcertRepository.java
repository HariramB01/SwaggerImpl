package com.concert.Repository;

import com.concert.Entity.Concert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ConcertRepository extends JpaRepository<Concert, Long> {
    List<Concert> findByArtistOrVenueOrDateTime(String artist, String venue, LocalDateTime dateTime);
}
