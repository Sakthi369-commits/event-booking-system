package com.sakthi.EventBooking.dtos;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookingRequestDto {
    
    @NotBlank(message = "Customer Name cannot be empty!") 
    private String customerName;
    
    @NotBlank
    @Email 
    private String email;
    
    @NotBlank
    private String phoneNumber;

    @NotNull 
    private Integer eventId;


    @NotBlank 
    private String seatNumber;

    @NotBlank 
    private String ticketCategory;

    @DecimalMin(
        value = "0.0",
        inclusive = false,
        message = "Price must be greater than zero"
    ) 
    private double price;

    public BookingRequestDto() {
    }

    public BookingRequestDto( String customerName, String email, String phoneNumber, 
                              Integer eventId, String seatNumber, String ticketCategory,
                              double price) {
        
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.eventId = eventId;
        this.seatNumber = seatNumber;
        this.ticketCategory = ticketCategory;
        this.price = price;
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

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
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

    

    


}
