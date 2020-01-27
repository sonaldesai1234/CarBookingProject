package com.mycipl.repository;

import com.mycipl.domain.CarBookingsCollection;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data MongoDB repository for the CarBookingsCollection entity.
 */
@SuppressWarnings("unchecked")
@Repository
public interface CarBookingsCollectionRepository extends MongoRepository<CarBookingsCollection, String> {

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

	List<CarBookingsCollection> findByDealerCodeAndStartingTimeBetween(String dealerCode,
			 Instant instantstart, Instant endinstant);

	CarBookingsCollection findOneByBookingId(String bookingId);
   
	CarBookingsCollection findOneByBookingIdAndDealerCode(String bookingId, String dealerCode);

	CarBookingsCollection findByBookingIdAndDealerCode(String bookingId, String dealerCode);

	List<CarBookingsCollection> findByCarModelEngineNumberAndDealerCodeAndStartingTimeBetween(
			String carModelEngineNumber, String dealerCode, Instant instantstart, Instant endinstant);

	List<CarBookingsCollection> findByStartingTimeBetween(Instant instantstart, Instant endinstant);

	List<CarBookingsCollection> findByStartingTimeBetweenAndDealerCode(Instant startingTime, Instant endTime,
			String dealerCode);

	List<CarBookingsCollection> findByStartingTimeBetweenAndDealerCodeAndDseLoginID(Instant startingTime,
			Instant endTime, String dealerCode, String dseLoginId);

	List<CarBookingsCollection> findByStartingTimeBetweenAndDealerCodeAndCarModelEngineNumber(Instant startingTime,
			Instant endTime, String dealerCode, String carModelEngineNumber);

	List<CarBookingsCollection> findByDseNameAndDealerCodeAndStartingTimeBetween(String dseName, String dealerCode,
			Instant instantstart, Instant endinstant);

 List<CarBookingsCollection> findByCarModelNameAndDealerCodeAndStartingTimeBetween(String carModelName,
			String dealerCode, Instant instantstart, Instant endinstant);
	

	CarBookingsCollection findOneById(String id);

	//List<CarBookingsCollection> findByStartingTimeBetweenAndDealerCodeAndDseLoginId(Instant startingTime,
			//Instant endTime, String dealerCode, String dseLoginId);

}

