package com.mycipl.service.impl;

import com.mycipl.service.TrackRideService;
import com.mycipl.domain.TrackRide;
import com.mycipl.repository.TrackRideRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link TrackRide}.
 */
@Service
public class TrackRideServiceImpl implements TrackRideService {

    private final Logger log = LoggerFactory.getLogger(TrackRideServiceImpl.class);

    private final TrackRideRepository trackRideRepository;

    public TrackRideServiceImpl(TrackRideRepository trackRideRepository) {
        this.trackRideRepository = trackRideRepository;
    }

    /**
     * Save a trackRide.
     *
     * @param trackRide the entity to save.
     * @return the persisted entity.
     */
    @Override
    public TrackRide save(TrackRide trackRide) {
        log.debug("Request to save TrackRide : {}", trackRide);
        return trackRideRepository.save(trackRide);
    }

    /**
     * Get all the trackRides.
     *
     * @return the list of entities.
     */
    @Override
    public List<TrackRide> findAll() {
        log.debug("Request to get all TrackRides");
        return trackRideRepository.findAll();
    }


    /**
     * Get one trackRide by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    public Optional<TrackRide> findOne(String id) {
        log.debug("Request to get TrackRide : {}", id);
        return trackRideRepository.findById(id);
    }

    /**
     * Delete the trackRide by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete TrackRide : {}", id);
        trackRideRepository.deleteById(id);
    }

	@Override
	public TrackRide findByBookingId(String bookingId) {
		// TODO Auto-generated method stub
		return trackRideRepository.findByBookingId(bookingId);
	}

	@Override
	public void deleteByBookingId(String bookingId) {
		trackRideRepository.deleteByBookingId(bookingId);
		
	}
}
