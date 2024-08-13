package com.concert.Entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "concert_id")
    private Concert concert;
    private String seatNumbers;
    private double totalPrice;
    private LocalDateTime bookingDate;
    private String status;  // e.g., 'CONFIRMED', 'CANCELLED'
    // Getters and Setters


    public Booking() {
    }

    public Booking(Long bookingId, User user, Concert concert, String seatNumbers, double totalPrice, LocalDateTime bookingDate, String status) {
        this.bookingId = bookingId;
        this.user = user;
        this.concert = concert;
        this.seatNumbers = seatNumbers;
        this.totalPrice = totalPrice;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    public String getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(String seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", user=" + user +
                ", concert=" + concert +
                ", seatNumbers='" + seatNumbers + '\'' +
                ", totalPrice=" + totalPrice +
                ", bookingDate=" + bookingDate +
                ", status='" + status + '\'' +
                '}';
    }
}
