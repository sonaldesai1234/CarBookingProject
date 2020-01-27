package com.mycipl.repository;

import com.mycipl.domain.TrackRide;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data MongoDB repository for the TrackRide entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TrackRideRepository extends MongoRepository<TrackRide, String> {

	TrackRide findByBookingId(String bookingId);

	void deleteByBookingId(String bookingId);

}
