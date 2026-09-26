package com.sakthi.EventBooking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.sakthi.EventBooking.dtos.BookingRequestDto;
import com.sakthi.EventBooking.dtos.BookingResponseDto;
import com.sakthi.EventBooking.exceptions.BookingNotFoundException;
import com.sakthi.EventBooking.exceptions.EventNotFoundException;
import com.sakthi.EventBooking.model.Booking;
import com.sakthi.EventBooking.model.Event;
import com.sakthi.EventBooking.repository.BookingRepository;
import com.sakthi.EventBooking.repository.EventRepository;

@Service
public class BookingService {

    private final BookingRepository repository;
    private final EventRepository eventRepository;

    public BookingService(BookingRepository repository , EventRepository eventRepository) {
        this.repository = repository;
        this.eventRepository = eventRepository;
    }

    // CREATE
    public void addBooking(BookingRequestDto bookingDto) {
        Booking booking = new Booking();
        Event event = eventRepository.findById(bookingDto.getEventId()).orElseThrow(() -> 
                      new EventNotFoundException("Event not found"));

        booking.setCustomerName(bookingDto.getCustomerName());
        booking.setEmail(bookingDto.getEmail());
        booking.setPhoneNumber(bookingDto.getPhoneNumber());
        booking.setEvent(event);
        booking.setSeatNumber(bookingDto.getSeatNumber());
        booking.setTicketCategory(bookingDto.getTicketCategory());
        booking.setPrice(bookingDto.getPrice());

        booking.setBookingStatus("CONFIRMED");

        repository.save(booking);
    }

    // READ ALL
    public List<BookingResponseDto> getAllBookings() {
        List<BookingResponseDto> bookingResponseDto = new ArrayList<>();
        for(Booking booking: repository.findAll()){
            bookingResponseDto.add(new BookingResponseDto(booking));
        }
        
        return bookingResponseDto;
    }

    // READ ONE
    public BookingResponseDto getBookingById(int id) {
        Optional<Booking> booking = repository.findById(id);
        
        if(booking.isEmpty()){
            throw new BookingNotFoundException("Booking not found.");
        }
        return new BookingResponseDto(booking.get());
    }

    // UPDATE
    public void updateBooking(int id, BookingRequestDto updatedBooking) {
        Booking booking = repository.findById(id).orElseThrow(() -> new BookingNotFoundException("Booking Not found"));
        Event event = eventRepository.findById(updatedBooking.getEventId())
            .orElseThrow(() -> new EventNotFoundException("Event not found"));

        booking.setCustomerName(updatedBooking.getCustomerName());
        booking.setEmail(updatedBooking.getEmail());
        booking.setPhoneNumber(updatedBooking.getPhoneNumber());
        booking.setEvent(event);
        booking.setSeatNumber(updatedBooking.getSeatNumber());
        booking.setTicketCategory(updatedBooking.getTicketCategory());
        booking.setPrice(updatedBooking.getPrice());

        repository.save(booking);
    }

    // DELETE
    public void deleteBooking(int id) {
        Booking booking = repository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found"));

        repository.delete(booking);
    }
}