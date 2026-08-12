package com.sakthi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sakthi.model.Booking;
import com.sakthi.repository.BookingRepository;

@Service
public class BookingService {

    private final BookingRepository repository;

    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Booking bookTicket(Booking booking) {
        return repository.save(booking);
    }

    // READ ALL
    public List<Booking> getAllBookings() {
        return repository.findAll();
    }

    // READ ONE
    public Optional<Booking> getBookingById(int id) {
        return repository.findById(id);
    }

    // UPDATE
    public Optional<Booking> updateBooking(int id, Booking updatedBooking) {

        Optional<Booking> existingBooking = repository.findById(id);

        if (existingBooking.isEmpty()) {
            return Optional.empty();
        }

        Booking booking = existingBooking.get();

        booking.setCustomerName(updatedBooking.getCustomerName());
        booking.setEmail(updatedBooking.getEmail());
        booking.setPhoneNumber(updatedBooking.getPhoneNumber());
        booking.setEventName(updatedBooking.getEventName());
        booking.setVenue(updatedBooking.getVenue());
        booking.setEventDate(updatedBooking.getEventDate());
        booking.setSeatNumber(updatedBooking.getSeatNumber());
        booking.setTicketCategory(updatedBooking.getTicketCategory());
        booking.setPrice(updatedBooking.getPrice());
        booking.setBookingStatus(updatedBooking.getBookingStatus());

        return Optional.of(repository.save(booking));
    }

    // DELETE
    public boolean deleteBooking(int id) {

        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }
}