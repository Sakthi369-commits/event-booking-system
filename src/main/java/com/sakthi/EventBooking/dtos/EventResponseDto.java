package com.sakthi.EventBooking.dtos;


import java.time.LocalDateTime;
import com.sakthi.EventBooking.model.Event;



public class EventResponseDto {
        
    private Integer id;
    private String eventName;
    private String venue;
    private LocalDateTime eventDate;

    public EventResponseDto() {
    }

    

    public EventResponseDto(Event event) {
        this.id = event.getId();
        this.eventName = event.getEventName();
        this.venue = event.getVenue();
        this.eventDate = event.getEventDate();
    }



    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }



    public String getEventName() {
        return eventName;
    }



    public void setEventName(String eventName) {
        this.eventName = eventName;
    }



    public String getVenue() {
        return venue;
    }



    public void setVenue(String venue) {
        this.venue = venue;
    }



    public LocalDateTime getEventDate() {
        return eventDate;
    }



    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }



    
    

}
