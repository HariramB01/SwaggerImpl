package com.concert.Service;

import com.concert.Entity.Booking;
import com.concert.Entity.Concert;
import com.concert.Entity.User;
import com.concert.Exception.ResourceNotFoundException;
import com.concert.Repository.BookingRepository;
import com.concert.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ConcertService concertService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Booking bookTickets(Long userId, Long concertId, String seatNumbers, double totalPrice) {
        // Retrieve the concert to check availability
        Concert concert = concertService.getConcertById(concertId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // Check seat availability (pseudo-logic, implement your own)
        if (!isSeatsAvailable(concertId, seatNumbers)) {
            throw new RuntimeException("Selected seats are not available");
        }

        // Create a new booking
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setConcert(concert);
        booking.setSeatNumbers(seatNumbers);
        booking.setTotalPrice(totalPrice);
        booking.setBookingDate(LocalDateTime.now());
        booking.setStatus("CONFIRMED");

        // Save booking to the repository
        return bookingRepository.save(booking);
    }

    @Transactional
    public void cancelBooking(Long bookingId) {
        // Retrieve the booking
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));

        // Update booking status
        booking.setStatus("CANCELLED");

        // Save updated booking
        bookingRepository.save(booking);
    }

    public List<Booking> getBooking() {
        return bookingRepository.findAll();
    }

    private boolean isSeatsAvailable(Long concertId, String seatNumbers) {
        // Implement logic to check seat availability
        // This could involve querying the booking repository for the same concertId and seatNumbers
        return true; // For simplicity, always returning true
    }

    public Optional<Booking> getBookingById(Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        return booking;
    }
}
