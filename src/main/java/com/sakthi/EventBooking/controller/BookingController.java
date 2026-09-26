package com.sakthi.EventBooking.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sakthi.EventBooking.dtos.BookingRequestDto;
import com.sakthi.EventBooking.dtos.BookingResponseDto;
import com.sakthi.EventBooking.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Void> addBooking(@Valid @RequestBody BookingRequestDto booking) {
        service.addBooking(booking);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // READ ALL
    @GetMapping
    public List<BookingResponseDto> getAllBookings() {
        return service.getAllBookings();
    }

    // READ ONE
    @GetMapping("/{id}")
    public BookingResponseDto getBookingById(@PathVariable int id) {
        return service.getBookingById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBooking(
            @PathVariable int id,
            @Valid @RequestBody BookingRequestDto booking) {

        service.updateBooking(id, booking);
        return ResponseEntity.noContent().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable int id) {
        service.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}