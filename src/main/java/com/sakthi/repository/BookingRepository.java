package com.sakthi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakthi.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}