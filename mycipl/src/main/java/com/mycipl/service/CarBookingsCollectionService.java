package com.mycipl.service;

import com.mycipl.domain.CarBookingsCollection;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link CarBookingsCollection}.
 */
public interface CarBookingsCollectionService {

    /**
     * Save a carBookingsCollection.
     *
     * @param carBookingsCollection the entity to save.
     * @return the persisted entity.
     */
    CarBookingsCollection save(CarBookingsCollection carBookingsCollection);

    /**
     * Get all the carBookingsCollections.
     *
     * @return the list of entities.
     */
    List<CarBookingsCollection> findAll();


    /**
     * Get the "id" carBookingsCollection.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
   

    /**
     * Delete the "id" carBookingsCollection.
     *
     * @param id the id of the entity.
     */
    void delete(String id);

	List<CarBookingsCollection> findByCustomerBookingDateAndDseLoginIDAndDealerCodeAndCarModelEngineNumber(
			Instant customerBookingDate, String dseLoginID, String dealerCode, String carModelEngineNumber);

	List<CarBookingsCollection> findAllByCustomerBookingDateAndDealerCodeAndDseLoginID(Instant customerBookingDate,
			String dealerCode, String dseLoginID);

	List<CarBookingsCollection> findAllByDseLoginIDAndDealerCodeAndCustomerBookingDate(String dseLoginID,
			String dealerCode, Instant customerBookingDate);

	List<CarBookingsCollection> findAllByBookingIdAndDseLoginIDAndCustomerBookingDateBetween(String bookingId,
			String dseLoginID, Instant instantstart, Instant endinstant);

	List<CarBookingsCollection> findByDseLoginIDAndDealerCodeAndCustomerFeedbackAndEndTimeBetween(String dseLoginID,
			String dealerCode, String customerFeedback, Instant instantstart, Instant endTime);

	List<CarBookingsCollection> findByDealerCodeAndStartingTimeBetween(String dealerCode, Instant instantstart,
			Instant endinstant);

	CarBookingsCollection findOneByBookingId(String bookingId);

	CarBookingsCollection findOneByBookingIdAndDealerCode(String bookingId, String dealerCode);

	CarBookingsCollection findByBookingIdAndDealerCode(String bookingId, String dealerCode);


	List<CarBookingsCollection> findByStartingTimeBetween(Instant instantstart, Instant endinstant);

	List<CarBookingsCollection> findByCarModelEngineNumberAndDealerCodeAndStartingTimeBetween(
			String carModelEngineNumber, String dealerCode, Instant instantstart, Instant endinstant);

	List<CarBookingsCollection> findByDseNameAndDealerCodeAndStartingTimeBetween(String dseName, String dealerCode,
			Instant instantstart, Instant endinstant);

	List<CarBookingsCollection> findByCarModelNameAndDealerCodeAndStartingTimeBetween(String carModelName,
			String dealerCode, Instant instantstart, Instant endinstant);

	Optional<CarBookingsCollection> findOne(String id);

	List<CarBookingsCollection> findByStartingTimeBetweenAndDealerCodeAndDseLoginID(Instant startingTime,
			Instant endTime, String dealerCode, String dseLoginId);

	List<CarBookingsCollection> findByStartingTimeBetweenAndDealerCodeAndCarModelEngineNumber(Instant startingTime,
			Instant endTime, String dealerCode, String carModelEngineNumber);

	CarBookingsCollection findOneById(String id);



	
}
