package com.sakthi.EventBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sakthi.EventBooking.model.Event;

public interface EventRepository extends JpaRepository<Event,Integer>{

   
}
