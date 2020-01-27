package com.mycipl.web.rest;

import java.io.FileReader;
import java.net.URISyntaxException;
import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mycipl.domain.CarBookingsCollection;
import com.mycipl.domain.CustomResponse;
import com.mycipl.repository.CarBookingsCollectionRepository;
import com.mycipl.security.AuthoritiesConstants;
import com.mycipl.service.CarBookingsCollectionService;
import com.mycipl.web.rest.errors.BadRequestAlertException;

@RestController
@RequestMapping("/api")
public class CarBookingsCollectionResource {

	private final Logger log = LoggerFactory.getLogger(CarBookingsCollectionResource.class);

	@Autowired
	CarBookingsCollectionRepository carBookingsCollectionRepository;

	private static final String ENTITY_NAME = "carBookingsCollection";

	private final CarBookingsCollectionService carBookingsCollectionService;
	CustomResponse customResponse = new CustomResponse();

	public CarBookingsCollectionResource(CarBookingsCollectionService carBookingsCollectionService) {
		this.carBookingsCollectionService = carBookingsCollectionService;
	}

	@SuppressWarnings("unused")
	@PostMapping("/carBooking")
	// @Secured({AuthoritiesConstants.ADMIN,
	// AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
	public Object createCarBookingsCollection(@RequestBody CarBookingsCollection carBookingsCollection)
			throws URISyntaxException {
		log.debug("REST request to save CarBookingsCollection : {}", carBookingsCollection);
		if (carBookingsCollection.getId() != null) {
			throw new BadRequestAlertException("A new carBookingsCollection cannot already have an ID", ENTITY_NAME,
					"idexists");

		}
		carBookingsCollection.setCreatedOn(Instant.now());
		carBookingsCollection.setUpdatedOn(Instant.now());

		System.out.println(carBookingsCollection);

		if (carBookingsCollection.getCustomerName() == null
				&& carBookingsCollection.getCustomerMobileNumber() == null) {
			customResponse.setStatus("Failure");
			customResponse.setStatusCode(404);
			customResponse.setMessage("Car Booking Not Created");
			customResponse.setResults(null);
			return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);

		}
		CarBookingsCollection result = carBookingsCollectionService.save(carBookingsCollection);
		customResponse.setStatus("Success");
		customResponse.setStatusCode(200);
		customResponse.setMessage("Car Bookings Created");
		customResponse.setResults(result);

		return customResponse;
	}

	

	@GetMapping("/carBookingSlot/{customerBookingDate}/{dseLoginID}/{dealerCode}/{carModelEngineNumber}")
	// @Secured({AuthoritiesConstants.ADMIN,
	// AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
	public Object getBookedSlot(@PathVariable Instant customerBookingDate, @PathVariable String dseLoginID,
			@PathVariable String dealerCode, @PathVariable String carModelEngineNumber) {
		if (customerBookingDate == null || dseLoginID == null || dealerCode == null || carModelEngineNumber == null
				|| "".equalsIgnoreCase(carModelEngineNumber) && "".equalsIgnoreCase(dealerCode)) {
			throw new BadRequestAlertException("Invalid Value", ENTITY_NAME,
					" customer booking date,dse login id,dealer code and Car Model Engine number cant be null");
		}

		List<CarBookingsCollection> carBookingsCollection = carBookingsCollectionService
				.findByCustomerBookingDateAndDseLoginIDAndDealerCodeAndCarModelEngineNumber(customerBookingDate,
						dseLoginID, dealerCode, carModelEngineNumber);

		if (carBookingsCollection.isEmpty()) {
			customResponse.setStatus("Failure");
			customResponse.setStatusCode(404);
			customResponse.setMessage(" Car Booking not Found");
			customResponse.setResults(null);
			return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);

		}
		customResponse.setStatus("Success");
		customResponse.setStatusCode(200);
		customResponse.setMessage("Car Bookings found");
		customResponse.setResults(carBookingsCollection);

		return customResponse;
	}

	@GetMapping("/carBookingByUserId/{customerBookingDate}/{dealerCode}/{teamLeader}/{dseLoginID}")
	// @Secured({AuthoritiesConstants.ADMIN,
	// AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
	public Object getCarScheduleListByUser(@PathVariable Instant customerBookingDate, @PathVariable String dealerCode,
			@PathVariable String teamLeader, @PathVariable String dseLoginID) {

		List<CarBookingsCollection> carBookingsCollection = carBookingsCollectionService
				.findAllByCustomerBookingDateAndDealerCodeAndDseLoginID(customerBookingDate, dealerCode, dseLoginID);
		if (carBookingsCollection.isEmpty()) {
			customResponse.setStatus("Failure");
			customResponse.setStatusCode(404);
			customResponse.setMessage("Car Booking not Found");

			customResponse.setResults(null);
			return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);

		}
		customResponse.setStatus("Success");
		customResponse.setStatusCode(200);
		customResponse.setMessage("Car Booking found");
		customResponse.setResults(carBookingsCollection);

		return customResponse;

	}

	@GetMapping("/carBooking/{customerBookingDate}/{dealerCode}/{dseLoginID}")
	// @Secured({AuthoritiesConstants.ADMIN,
	// AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
	public Object getMyScheduleListForUser(@PathVariable Instant customerBookingDate, @PathVariable String dealerCode,
			@PathVariable String dseLoginID) {

		//Instant instantstart = Instant.parse(customerBookingDate);
		
		List<CarBookingsCollection> carBookingsCollection = carBookingsCollectionService
				.findAllByDseLoginIDAndDealerCodeAndCustomerBookingDate(dseLoginID, dealerCode, customerBookingDate);

		if (carBookingsCollection.isEmpty()) {
			customResponse.setStatus("Failure");
			customResponse.setStatusCode(404);
			customResponse.setMessage("Car booking Not Found");

			customResponse.setResults(null);
			return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);

		}
		customResponse.setStatus("Success");
		customResponse.setStatusCode(200);
		customResponse.setMessage("Car Booking found");
		customResponse.setResults(carBookingsCollection);

		return customResponse;
	}

	@GetMapping("/carBookingById/{bookingId}/{dseLoginID}/{customerBookingDate}")
	// @Secured({AuthoritiesConstants.ADMIN,
	// AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
	public Object getMyScheduleListForSevenDaysForOther(@PathVariable String bookingId, @PathVariable String dseLoginID,
			@PathVariable Instant customerBookingDate) {

		Instant instantstart = Instant.parse(customerBookingDate.toString());
		instantstart = instantstart.minus(Duration.ofDays(4));
		System.out.println(instantstart);
		Instant endinstant = Instant.parse(customerBookingDate.toString());
		endinstant = endinstant.plus(Duration.ofDays(4));
		System.out.println(endinstant);

		List<CarBookingsCollection> carBookingsCollection = carBookingsCollectionService
				.findAllByBookingIdAndDseLoginIDAndCustomerBookingDateBetween(bookingId, dseLoginID, instantstart,
						endinstant);

		if (carBookingsCollection.isEmpty()) {
			customResponse.setStatus("Failure");
			customResponse.setStatusCode(404);
			customResponse.setMessage("Car Bookings Not found");

			customResponse.setResults(null);
			return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);

		}
		customResponse.setStatus("Success");
		customResponse.setStatusCode(200);
		customResponse.setMessage("Car Bookings found");
		customResponse.setResults(carBookingsCollection);

		return customResponse;
	}

	@GetMapping("/pendingActions/{dseLoginID}/{dealerCode}/{customerFeedback}/{endTime}")
	// @Secured({AuthoritiesConstants.ADMIN,
	// AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
	public Object getPendingActionsForUser(@PathVariable String dseLoginID, @PathVariable String dealerCode,
			@PathVariable String customerFeedback, @PathVariable Instant endTime) {

		if (dseLoginID == null || dealerCode == null || customerFeedback == null
				|| endTime == null && "".equalsIgnoreCase(dseLoginID) && "".equalsIgnoreCase(dealerCode)
						&& "".equalsIgnoreCase(customerFeedback))

		{
			throw new BadRequestAlertException("Invalid Value", ENTITY_NAME,
					" customer booking date,dealer code and Car Model Engine number cant be null");
		}

		Instant instantstart = Instant.parse(endTime.toString());
		instantstart = instantstart.minus(Duration.ofDays(100));

		List<CarBookingsCollection> carBookingsCollection = carBookingsCollectionService
				.findByDseLoginIDAndDealerCodeAndCustomerFeedbackAndEndTimeBetween(dseLoginID, dealerCode,
						customerFeedback, instantstart, endTime);

		if (carBookingsCollection.isEmpty()) {
			customResponse.setStatus("Failure");
			customResponse.setStatusCode(404);
			customResponse.setMessage("Car Bookings Not found");

			customResponse.setResults(null);
			return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);

		} else {
			customResponse.setStatus("Success");
			customResponse.setStatusCode(200);
			customResponse.setMessage("Car Bookings found");
			customResponse.setResults(carBookingsCollection);

			return customResponse;
		}

	}

	@GetMapping("/carBookingByTime/{dealerCode}/{startingTime}/{endTime}")
	// @Secured({AuthoritiesConstants.ADMIN,
	// AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
	public Object getUserListForReassignSchedule(@PathVariable String dealerCode, @PathVariable Instant startingTime,
			@PathVariable Instant endTime) {
		log.debug("REST request for get all bookong data by delercode,start n end date wise");

		if (endTime == null || startingTime == null || dealerCode == null) {
			throw new BadRequestAlertException("Invalid Value", ENTITY_NAME,
					" startingTime, endTime, dealerCode cant be null");
		}

		Instant instantstart = Instant.parse(startingTime.toString());
		instantstart = instantstart.minus(Duration.ofDays(1));

		System.out.println(instantstart);

		Instant endinstant = Instant.parse(endTime.toString());
		endinstant = endinstant.plus(Duration.ofDays(1));
		System.out.println(endinstant);

		List<CarBookingsCollection> carBookingsCollection = carBookingsCollectionService
				.findByDealerCodeAndStartingTimeBetween(dealerCode, instantstart, endinstant);

		if (carBookingsCollection.isEmpty()) {
			customResponse.setStatus("Failure");
			customResponse.setStatusCode(404);
			customResponse.setMessage("Car Bookings Not found");

			customResponse.setResults(null);
			return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);

		}

		customResponse.setStatus("Success");
		customResponse.setStatusCode(200);
		customResponse.setMessage("Car Bookings found");
		customResponse.setResults(carBookingsCollection);
		return customResponse;
	}

	@GetMapping("/carBookingDetail/{startingTime}/{endTime}/{carModelEngineNumber}/{dealerCode}")
	// @Secured({AuthoritiesConstants.ADMIN,
	// AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
	public Object getUserList(@PathVariable Instant startingTime, @PathVariable Instant endTime,
			@PathVariable String carModelEngineNumber, @PathVariable String dealerCode) {

		if (endTime == null || startingTime == null || carModelEngineNumber == null || dealerCode == null) {
			throw new BadRequestAlertException("Invalid Value", ENTITY_NAME,
					" startingTime ,endTime,Car Model Engine number and dealerCodecant be null");
		}

		Instant instantstart = Instant.parse(startingTime.toString());
		instantstart = instantstart.minus(Duration.ofDays(1));

		System.out.println(instantstart);

		Instant endinstant = Instant.parse(endTime.toString());
		endinstant = endinstant.plus(Duration.ofDays(1));
		System.out.println(endinstant);

		List<CarBookingsCollection> carBookingsCollection = carBookingsCollectionService
				.findByCarModelEngineNumberAndDealerCodeAndStartingTimeBetween(carModelEngineNumber, dealerCode,
						instantstart, endinstant);

		if (carBookingsCollection.isEmpty()) {
			customResponse.setStatus("Failure");
			customResponse.setStatusCode(404);
			customResponse.setMessage("Car Bookings Not found");

			customResponse.setResults(null);
			return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);

		}

		customResponse.setStatus("Success");
		customResponse.setStatusCode(200);
		customResponse.setMessage("Car Bookings found");
		customResponse.setResults(carBookingsCollection);
		return customResponse;
	}

	@GetMapping("/carBookingDate/{dseName}/{dealerCode}/{startingTime}/{endTime}")
	// @Secured({AuthoritiesConstants.ADMIN,
	// AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
	public Object getdse(@PathVariable String dseName, @PathVariable String dealerCode,
			@PathVariable Instant startingTime, @PathVariable Instant endTime) {

		if (endTime == null || startingTime == null || dseName == null || dealerCode == null) {
			throw new BadRequestAlertException("Invalid Value", ENTITY_NAME,
					" startingTime ,endTime,dseName and dealer code ");
		}

		Instant instantstart = Instant.parse(startingTime.toString());
		instantstart = instantstart.minus(Duration.ofDays(1));

		System.out.println(instantstart);

		Instant endinstant = Instant.parse(endTime.toString());
		endinstant = endinstant.plus(Duration.ofDays(1));
		System.out.println(endinstant);

		List<CarBookingsCollection> carBookingsCollection = carBookingsCollectionService
				.findByDseNameAndDealerCodeAndStartingTimeBetween(dseName, dealerCode, instantstart, endinstant);

		if (carBookingsCollection.isEmpty()) {
			customResponse.setStatus("Failure");
			customResponse.setStatusCode(404);
			customResponse.setMessage("Car Bookings Not found");

			customResponse.setResults(null);
			return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);

		}

		customResponse.setStatus("Success");
		customResponse.setStatusCode(200);
		customResponse.setMessage("Car Bookings found");
		customResponse.setResults(carBookingsCollection);
		return customResponse;
	}

	@GetMapping("/carBookingModelName/{carModelName}/{dealerCode}/{startingTime}/{endTime}")
	// @Secured({AuthoritiesConstants.ADMIN,
	// AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
	public Object getcarModel(@PathVariable String carModelName, @PathVariable String dealerCode,
			@PathVariable Instant startingTime, @PathVariable Instant endTime) {

		if (endTime == null || startingTime == null || carModelName == null || dealerCode == null) {
			throw new BadRequestAlertException("Invalid Value", ENTITY_NAME,
					" startingTime ,endTime,delear code and car model name");
		}

		Instant instantstart = Instant.parse(startingTime.toString());
		instantstart = instantstart.minus(Duration.ofDays(1));

		// System.out.println(instantstart);

		Instant endinstant = Instant.parse(endTime.toString());
		endinstant = endinstant.plus(Duration.ofDays(1));
		System.out.println(endinstant);

		List<CarBookingsCollection> carBookingsCollection = carBookingsCollectionService.findByCarModelNameAndDealerCodeAndStartingTimeBetween(carModelName,dealerCode,instantstart,endinstant);

		//System.out.println("******************"+carBookingsCollection);
		
		if (carBookingsCollection.isEmpty()) {
			customResponse.setStatus("Failure");
			customResponse.setStatusCode(404);
			customResponse.setMessage("Car Bookings Not found");

			customResponse.setResults(null);
			return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);

		}

		customResponse.setStatus("Success");
		customResponse.setStatusCode(200);
		customResponse.setMessage("Car Bookings found");
		customResponse.setResults(carBookingsCollection);
		return customResponse;
		
	}

	@PutMapping("/carBooking/{dealerCode}/{bookingId}")
	// @Secured({AuthoritiesConstants.ADMIN,
	// AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})

	public Object CarBookingsCollectionupdate(@RequestBody CarBookingsCollection carBookingsCollectionObj,
			@PathVariable String dealerCode, @PathVariable String bookingId) throws URISyntaxException {
		log.debug("REST request to update CarBookingsCollectionupdate : {}", carBookingsCollectionObj);

		CarBookingsCollection carBookingsCollection = carBookingsCollectionService
				.findOneByBookingIdAndDealerCode(bookingId, dealerCode);
		String id = carBookingsCollection.getId();
		carBookingsCollectionObj.setId(id);

		if (carBookingsCollection != null) {
			try {
				carBookingsCollectionObj.setUpdatedOn(Instant.now());
				CarBookingsCollection result = carBookingsCollectionService.save(carBookingsCollectionObj);
				customResponse.setStatus("Success");
				customResponse.setStatusCode(200);
				customResponse.setMessage("Car Booking Updated");
				customResponse.setResults(result);

			} catch (Exception e) {
				customResponse.setStatus("Failure");
				customResponse.setStatusCode(404);
				customResponse.setMessage("Car Booking Not Updated");
				customResponse.setResults(null);
				// return new ResponseEntity<CustomResponse>(CustomResponse,
				// HttpStatus.NOT_FOUND);
				return customResponse;
			}

		}

		return customResponse;

	}

	@SuppressWarnings("unused")
	@DeleteMapping("/carBookings/{bookingId}")
	// @Secured({AuthoritiesConstants.ADMIN,
	// AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
	public Object deleteBooking(@PathVariable String bookingId) {

		CarBookingsCollection carBookingsCollection = carBookingsCollectionService.findOneByBookingId(bookingId);
		String id = carBookingsCollection.getId();

		if (carBookingsCollection == null) {
			customResponse.setStatus("Failure");
			customResponse.setMessage("Car booking record not found");
			return new ResponseEntity<>(customResponse, HttpStatus.NOT_FOUND);
		}

		try {
			carBookingsCollectionService.delete(id);
		}

		catch (Exception e) {
			customResponse.setStatus("Failure");
			customResponse.setMessage("Car booking record not deleted");
			return new ResponseEntity<>(customResponse, HttpStatus.BAD_REQUEST);
		}

		customResponse.setStatus("Success");
		customResponse.setMessage("Car booking record deleted");
		customResponse.setResults(null);
		return customResponse;

	}

	@GetMapping("/carBooking/{startingTime}/{endTime}")
	// @Secured({AuthoritiesConstants.ADMIN,
	// AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
	public Object getUserList(@PathVariable Instant startingTime, @PathVariable Instant endTime) {
		log.debug("REST request for get all bookong data by start n end date wise");

		if (endTime == null || startingTime == null) {
			throw new BadRequestAlertException("Invalid Value", ENTITY_NAME, " startingTime ,endTime cant be null");
		}
		
		List<CarBookingsCollection> carBookingsCollection = carBookingsCollectionService
				.findByStartingTimeBetween(startingTime,endTime);
		System.out.println("carBookingsCollection =====" + carBookingsCollection);

		if (carBookingsCollection == null || carBookingsCollection.isEmpty()) {
			customResponse.setStatus("Failure");
			customResponse.setStatusCode(404);
			customResponse.setMessage("Car Bookings Not found");

			customResponse.setResults(null);
			return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);
		}
		customResponse.setStatus("Success");
		customResponse.setStatusCode(200);
		customResponse.setMessage("Car Bookings found");
		customResponse.setResults(carBookingsCollection);
		return customResponse;
	}

	@GetMapping("/booking/{startingTime}/{endTime}/{dseLoginId}/{dealerCode}")
	// @Secured({AuthoritiesConstants.ADMIN,
	// AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
	public Object getUserListBySEDD(@PathVariable Instant startingTime, @PathVariable Instant endTime,
			@PathVariable String dseLoginId, @PathVariable String dealerCode) {
		log.debug("REST request for get all bookong data by start n end date wise");

		if (endTime == null || startingTime == null || dseLoginId == null || dealerCode == null) {
			throw new BadRequestAlertException("Invalid Value", ENTITY_NAME,
					" startingTime ,endTime, dseLoginId, dealerCode  cant be null");
		}
		List<CarBookingsCollection> carBookingsCollection = carBookingsCollectionService
				.findByStartingTimeBetweenAndDealerCodeAndDseLoginID(startingTime, endTime, dealerCode, dseLoginId);
		System.out.println("carBookingsCollection =====" + carBookingsCollection);

		if (carBookingsCollection == null || carBookingsCollection.isEmpty()) {
			customResponse.setStatus("Failure");
			customResponse.setStatusCode(404);
			customResponse.setMessage("Car Bookings Not found");
			customResponse.setResults(null);
			return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);
		}
		customResponse.setStatus("Success");
		customResponse.setStatusCode(200);
		customResponse.setMessage("Car Bookings found");
		customResponse.setResults(carBookingsCollection);
		return customResponse;
	}

	@GetMapping("/carBookings/{startingTime}/{endTime}/{carModelEngineNumber}/{dealerCode}")
	/*@Secured({ AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER, AuthoritiesConstants.MANAGER,
			AuthoritiesConstants.TEAMLEADER, AuthoritiesConstants.DSE })*/
	public Object getUserListBySECD(@PathVariable Instant startingTime, @PathVariable Instant endTime,
			@PathVariable String carModelEngineNumber, @PathVariable String dealerCode) {
		log.debug("REST request for get all bookong data by start n end date wise");

		if (endTime == null || startingTime == null || carModelEngineNumber == null || dealerCode == null) {
			throw new BadRequestAlertException("Invalid Value", ENTITY_NAME,
					" startingTime ,endTime, carModelEngineNumber, dealerCode  cant be null");
		}
		List<CarBookingsCollection> carBookingsCollection = carBookingsCollectionService
				.findByStartingTimeBetweenAndDealerCodeAndCarModelEngineNumber(startingTime, endTime, dealerCode,
						carModelEngineNumber);
		System.out.println("carBookingsCollection =====" + carBookingsCollection);

		if (carBookingsCollection == null || carBookingsCollection.isEmpty()) {
			customResponse.setStatus("Failure");
			customResponse.setStatusCode(404);
			customResponse.setMessage("Car Bookings Not found");

			customResponse.setResults(null);
			return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);
		}
		customResponse.setStatus("Success");
		customResponse.setStatusCode(200);
		customResponse.setMessage("Car Bookings found");
		customResponse.setResults(carBookingsCollection);
		return customResponse;
	}

	@GetMapping("/carBooking/{id}")
	// @Secured({AuthoritiesConstants.ADMIN,
	// AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
	public Object getCar(@PathVariable String id)

	{

		CarBookingsCollection carBookingsCollection = carBookingsCollectionService.findOneById(id);

		if (carBookingsCollection == null) {
			customResponse.setStatus("Failure");
			;
			customResponse.setStatusCode(404);
			customResponse.setMessage("Car Booking not Found");

			customResponse.setResults(null);
			return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);

		}
		customResponse.setStatus("Success");
		customResponse.setStatusCode(200);
		customResponse.setMessage("Car Booking found");
		customResponse.setResults(carBookingsCollection);

		return customResponse;

	}

}
