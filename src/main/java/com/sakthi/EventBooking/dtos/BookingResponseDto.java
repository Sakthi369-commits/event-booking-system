package com.sakthi.EventBooking.dtos;


import com.sakthi.EventBooking.model.Booking;

public class BookingResponseDto {
        
    private Integer id;
    private String customerName;
    private String email;
    private String phoneNumber;
    private EventResponseDto event;
    private String seatNumber;
    private String ticketCategory;
    private double price;
    private String bookingStatus;
    
    public BookingResponseDto() {
    }

    public BookingResponseDto(Booking booking) {
        this.id = booking.getId();
        this.customerName = booking.getCustomerName();
        this.email = booking.getEmail();
        this.phoneNumber = booking.getPhoneNumber();
        this.event = new EventResponseDto(booking.getEvent());
        this.seatNumber = booking.getSeatNumber();
        this.ticketCategory = booking.getTicketCategory();
        this.price = booking.getPrice();
        this.bookingStatus = booking.getBookingStatus();
    }

    public Integer getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public EventResponseDto getEvent() {
        return event;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getTicketCategory() {
        return ticketCategory;
    }

    public double getPrice() {
        return price;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    

}
