package com.mycipl.service;

import com.mycipl.domain.TrackRide;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link TrackRide}.
 */
public interface TrackRideService {

    /**
     * Save a trackRide.
     *
     * @param trackRide the entity to save.
     * @return the persisted entity.
     */
    TrackRide save(TrackRide trackRide);

    /**
     * Get all the trackRides.
     *
     * @return the list of entities.
     */
    List<TrackRide> findAll();


    /**
     * Get the "id" trackRide.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TrackRide> findOne(String id);

    /**
     * Delete the "id" trackRide.
     *
     * @param id the id of the entity.
     */
    void delete(String id);

	TrackRide findByBookingId(String bookingId);

	void deleteByBookingId(String bookingId);
}
