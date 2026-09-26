package com.sakthi.EventBooking.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Customer name cannot be empty")
    private String customerName;

    @NotBlank 
    @Email 
    private String email;

    @NotBlank
    private String phoneNumber;

    @ManyToOne 
    @JoinColumn(name = "event_id") 
    private Event event;

    @NotBlank
    private String seatNumber;

    @NotBlank
    private String ticketCategory;

    @DecimalMin(
        value = "0.0",
        inclusive = false,
        message = "Price must be greater than zero") 
    private double price;

    @NotBlank 
    private String bookingStatus;

    public Booking() {
    }

    public Booking(Integer id, String customerName, String email, String phoneNumber,
                   Event event, String seatNumber, String ticketCategory, double price,
                   String bookingStatus) {

        this.id = id;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.event = event;
        this.seatNumber = seatNumber;
        this.ticketCategory = ticketCategory;
        this.price = price;
        this.bookingStatus = bookingStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getTicketCategory() {
        return ticketCategory;
    }

    public void setTicketCategory(String ticketCategory) {
        this.ticketCategory = ticketCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}