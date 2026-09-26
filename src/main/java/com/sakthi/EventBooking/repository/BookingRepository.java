package com.sakthi.EventBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sakthi.EventBooking.model.Booking;


public interface BookingRepository extends JpaRepository<Booking,Integer>{

   
}