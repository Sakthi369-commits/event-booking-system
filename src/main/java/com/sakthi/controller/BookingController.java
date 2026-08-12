package com.sakthi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sakthi.model.Booking;
import com.sakthi.service.BookingService;

import jakarta.validation.Valid;

@RestController
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping("/bookings")
    public Booking createBooking(@Valid @RequestBody Booking booking) {
        return service.bookTicket(booking);
    }

    // READ ALL
    @GetMapping("/bookings")
    public List<Booking> listAllBookings() {
        return service.getAllBookings();
    }

    // READ ONE
    @GetMapping("/bookings/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable int id) {

        Optional<Booking> booking = service.getBookingById(id);

        if (booking.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(booking.get());
    }

    // UPDATE
    @PutMapping("/bookings/{id}")
    public ResponseEntity<Booking> updateBooking(
            @PathVariable int id,
            @Valid @RequestBody Booking booking) {

        Optional<Booking> updatedBooking =
                service.updateBooking(id, booking);

        if (updatedBooking.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedBooking.get());
    }

    // DELETE
    @DeleteMapping("/bookings/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable int id) {

        boolean deleted = service.deleteBooking(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}