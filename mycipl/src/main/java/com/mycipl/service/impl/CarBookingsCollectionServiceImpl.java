package com.mycipl.service.impl;

import com.mycipl.service.CarBookingsCollectionService;
import com.mycipl.domain.CarBookingsCollection;
import com.mycipl.repository.CarBookingsCollectionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link CarBookingsCollection}.
 */
@Service
public class CarBookingsCollectionServiceImpl implements CarBookingsCollectionService {

    private final Logger log = LoggerFactory.getLogger(CarBookingsCollectionServiceImpl.class);

    private final CarBookingsCollectionRepository carBookingsCollectionRepository;

    public CarBookingsCollectionServiceImpl(CarBookingsCollectionRepository carBookingsCollectionRepository) {
        this.carBookingsCollectionRepository = carBookingsCollectionRepository;
    }

    /**
     * Save a carBookingsCollection.
     *
     * @param carBookingsCollection the entity to save.
     * @return the persisted entity.
     */
    @Override
    public CarBookingsCollection save(CarBookingsCollection carBookingsCollection) {
        log.debug("Request to save CarBookingsCollection : {}", carBookingsCollection);
        return carBookingsCollectionRepository.save(carBookingsCollection);
    }

    /**
     * Get all the carBookingsCollections.
     *
     * @return the list of entities.
     */
    @Override
    public List<CarBookingsCollection> findAll() {
        log.debug("Request to get all CarBookingsCollections");
        return carBookingsCollectionRepository.findAll();
    }


    /**
     * Get one carBookingsCollection by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    public Optional<CarBookingsCollection> findOne(String id) {
        log.debug("Request to get CarBookingsCollection : {}", id);
        return carBookingsCollectionRepository.findById(id);
    }

    /**
     * Delete the carBookingsCollection by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete CarBookingsCollection : {}", id);
        carBookingsCollectionRepository.deleteById(id);
    }

	@Override
	public List<CarBookingsCollection> findByCustomerBookingDateAndDseLoginIDAndDealerCodeAndCarModelEngineNumber(
			Instant customerBookingDate, String dseLoginID, String dealerCode, String carModelEngineNumber) {
		
		return carBookingsCollectionRepository.findByCustomerBookingDateAndDseLoginIDAndDealerCodeAndCarModelEngineNumber(customerBookingDate,dseLoginID,dealerCode,carModelEngineNumber);
	}

	@Override
	public List<CarBookingsCollection> findAllByCustomerBookingDateAndDealerCodeAndDseLoginID(
			Instant customerBookingDate, String dealerCode, String dseLoginID) {
		return carBookingsCollectionRepository.findAllByCustomerBookingDateAndDealerCodeAndDseLoginID(customerBookingDate, dealerCode, dseLoginID);}

	@Override
	public List<CarBookingsCollection> findAllByDseLoginIDAndDealerCodeAndCustomerBookingDate(String dseLoginID,
			String dealerCode, Instant customerBookingDate) {
		return carBookingsCollectionRepository.findAllByDseLoginIDAndDealerCodeAndCustomerBookingDate(dseLoginID,dealerCode,customerBookingDate);
	}

	@Override
	public List<CarBookingsCollection> findAllByBookingIdAndDseLoginIDAndCustomerBookingDateBetween(String bookingId,
			String dseLoginID, Instant instantstart, Instant endinstant) {
		// TODO Auto-generated method stub
		return carBookingsCollectionRepository.findAllByBookingIdAndDseLoginIDAndCustomerBookingDateBetween(bookingId,dseLoginID,instantstart,endinstant);
	}

	@Override
	public List<CarBookingsCollection> findByDseLoginIDAndDealerCodeAndCustomerFeedbackAndEndTimeBetween(
			String dseLoginID, String dealerCode, String customerFeedback, Instant instantstart, Instant endTime) {
		// TODO Auto-generated method stub
		return carBookingsCollectionRepository.findByDseLoginIDAndDealerCodeAndCustomerFeedbackAndEndTimeBetween(dseLoginID, dealerCode, customerFeedback, instantstart, endTime);
	}

	@Override
	public List<CarBookingsCollection> findByDealerCodeAndStartingTimeBetween(String dealerCode, Instant instantstart,
			Instant endinstant) {
		// TODO Auto-generated method stub
		return carBookingsCollectionRepository.findByDealerCodeAndStartingTimeBetween(dealerCode, instantstart, endinstant);
	}

	@Override
	public CarBookingsCollection findOneByBookingId(String bookingId) {
		// TODO Auto-generated method stub
		return carBookingsCollectionRepository.findOneByBookingId(bookingId);
	}

	@Override
	public CarBookingsCollection findOneByBookingIdAndDealerCode(String bookingId, String dealerCode) {
		// TODO Auto-generated method stub
		return carBookingsCollectionRepository.findOneByBookingIdAndDealerCode(bookingId,dealerCode);
	}

	@Override
	public CarBookingsCollection findByBookingIdAndDealerCode(String bookingId, String dealerCode) {
		// TODO Auto-generated method stub
		return carBookingsCollectionRepository.findByBookingIdAndDealerCode(bookingId,dealerCode);
	}


	@Override
	public List<CarBookingsCollection> findByCarModelEngineNumberAndDealerCodeAndStartingTimeBetween(
			String carModelEngineNumber, String dealerCode, Instant instantstart, Instant endinstant) {
		// TODO Auto-generated method stub
		return  carBookingsCollectionRepository.findByCarModelEngineNumberAndDealerCodeAndStartingTimeBetween(
				carModelEngineNumber, dealerCode, instantstart, endinstant);
	}

	@Override
	public List<CarBookingsCollection> findByStartingTimeBetween(Instant instantstart, Instant endinstant) {
		// TODO Auto-generated method stub
		return carBookingsCollectionRepository.findByStartingTimeBetween(instantstart,endinstant);
	}	

	@Override
	public List<CarBookingsCollection> findByDseNameAndDealerCodeAndStartingTimeBetween(String dseName,
			String dealerCode, Instant instantstart, Instant endinstant) {
		// TODO Auto-generated method stub
		return carBookingsCollectionRepository.findByDseNameAndDealerCodeAndStartingTimeBetween(dseName,
				dealerCode,  instantstart,  endinstant);
	}


	@Override
	public List<CarBookingsCollection> findByStartingTimeBetweenAndDealerCodeAndDseLoginID(Instant startingTime,
			Instant endTime, String dealerCode, String dseLoginId) {
		// TODO Auto-generated method stub
		return carBookingsCollectionRepository.findByStartingTimeBetweenAndDealerCodeAndDseLoginID( startingTime,
				 endTime,  dealerCode,  dseLoginId);
	}

	@Override
	public List<CarBookingsCollection> findByStartingTimeBetweenAndDealerCodeAndCarModelEngineNumber(
			Instant startingTime, Instant endTime, String dealerCode, String carModelEngineNumber) {
		// TODO Auto-generated method stub
		return carBookingsCollectionRepository.findByStartingTimeBetweenAndDealerCodeAndCarModelEngineNumber(
				 startingTime,  endTime,  dealerCode,  carModelEngineNumber);
	}

	@Override
	public CarBookingsCollection findOneById(String id) {
		// TODO Auto-generated method stub
		return carBookingsCollectionRepository.findOneById(id);
	}

	@Override
	public List<CarBookingsCollection> findByCarModelNameAndDealerCodeAndStartingTimeBetween(String carModelName,
			String dealerCode, Instant instantstart, Instant endinstant) {
		
		return carBookingsCollectionRepository.findByCarModelNameAndDealerCodeAndStartingTimeBetween(carModelName,
				dealerCode, instantstart,endinstant);
	}

}

	

	
    
    
  
    
