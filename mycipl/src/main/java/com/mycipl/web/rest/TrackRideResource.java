package com.mycipl.web.rest;

import com.mycipl.domain.CustomResponse;
import com.mycipl.domain.TrackRide;
import com.mycipl.repository.TrackRideRepository;
import com.mycipl.security.AuthoritiesConstants;
import com.mycipl.service.TrackRideService;
import com.mycipl.web.rest.errors.BadRequestAlertException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.mycipl.domain.TrackRide}.
 */
@RestController
@RequestMapping("/api")
public class TrackRideResource {

    private final Logger log = LoggerFactory.getLogger(TrackRideResource.class);

    private static final String ENTITY_NAME = "trackRide";

	/*
	 * @Value("${jhipster.clientApp.name}") private String applicationName;
	 */
   
    private final TrackRideService trackRideService;

    public TrackRideResource(TrackRideService trackRideService) {
        this.trackRideService = trackRideService;
    }

    /**
     * {@code POST  /track-rides} : Create a new trackRide.
     *
     * @param trackRide the trackRide to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new trackRide, or with status {@code 400 (Bad Request)} if the trackRide has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/trackRides")
   // @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object createTrackRide(@RequestBody TrackRide trackRide) throws URISyntaxException {
        log.debug("REST request to save TrackRide : {}", trackRide);
        if (trackRide.getId() != null) {
            throw new BadRequestAlertException("A new trackRide cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CustomResponse CustomResponse=new CustomResponse();
        
        if(trackRide.getBookingId()==null||trackRide.getDseLoginID()==null){
      	   CustomResponse.setStatus("Failure");
      	   CustomResponse.setStatusCode(404);
      	   CustomResponse.setMessage("TrackRide Not Created");
       	   CustomResponse.setResults(null);
      	   return new ResponseEntity<CustomResponse>(CustomResponse, HttpStatus.BAD_REQUEST);  
       	  
         }
           TrackRide result = trackRideService.save(trackRide);
           CustomResponse.setStatus("Success");
           CustomResponse.setStatusCode(200);;
           CustomResponse.setMessage("TrackRide Created");
           CustomResponse.setResults(result);
     	  
     	  return CustomResponse;
        
      
    }

    /**
     * {@code PUT  /track-rides} : Updates an existing trackRide.
     *
     * @param trackRide the trackRide to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated trackRide,
     * or with status {@code 400 (Bad Request)} if the trackRide is not valid,
     * or with status {@code 500 (Internal Server Error)} if the trackRide couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/trackRides/{bookingId}")
    //@Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object updateTrackRide(@RequestBody TrackRide trackRide, @PathVariable String bookingId) throws URISyntaxException {
        log.debug("REST request to update TrackRide : {}", trackRide);
		/*
		 * if (trackRide.getId() == null) { throw new
		 * BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull"); }
		 */
       
        TrackRide trackRideObj =trackRideService.findByBookingId(bookingId);
        String id=trackRideObj.getId();
        trackRide.setId(id);
        CustomResponse CustomResponse=new CustomResponse();
        
        if(trackRide.getBookingId()==null||trackRide.getDseLoginID()==null){
      	   
           CustomResponse.setStatus("Failure");
      	   CustomResponse.setStatusCode(404);
      	   CustomResponse.setMessage("TrackRide Not Updated");
       	   CustomResponse.setResults(null);
      	   return new ResponseEntity<CustomResponse>(CustomResponse, HttpStatus.BAD_REQUEST);  
       	  
         }
           TrackRide result = trackRideService.save(trackRide);
           CustomResponse.setStatus("Success");
           CustomResponse.setStatusCode(200);;
           CustomResponse.setMessage("TrackRide Updated");
           CustomResponse.setResults(result);
     	  
     	  return CustomResponse;
    }

    /**
     * {@code GET  /track-rides} : get all the trackRides.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of trackRides in body.
     */
    @GetMapping("/trackRides")
    //@Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object getAllTrackRides() {
        log.debug("REST request to get all TrackRides");
        CustomResponse CustomResponse=new CustomResponse();
        
        List<TrackRide> trackRide =trackRideService.findAll();
        if(trackRide==null)
        {
     	   CustomResponse.setStatus("Failure");
     	   CustomResponse.setStatusCode(404);
     	   CustomResponse.setMessage("TrackRide not Found");
      	   CustomResponse.setResults(null);
     	  return new ResponseEntity<CustomResponse>(CustomResponse, HttpStatus.BAD_REQUEST);  
      	  
        }
      	  
          CustomResponse.setStatus("Success");
          CustomResponse.setStatusCode(200);;
          CustomResponse.setMessage("TrackRide Found");
          CustomResponse.setResults(trackRide);
    	     return CustomResponse;
          }
    
    
    
    @GetMapping("/trackRidesByBookingId/{bookingId}")
    //@Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object TrackRidesByBookingId(@PathVariable String bookingId) {
        log.debug("REST request to get all TrackRides");
        CustomResponse CustomResponse=new CustomResponse();
        
        TrackRide trackRide =trackRideService.findByBookingId(bookingId);
        if(trackRide==null)
        {
     	   CustomResponse.setStatus("Failure");
     	   CustomResponse.setStatusCode(404);
     	   CustomResponse.setMessage("TrackRide not Found");
      	   CustomResponse.setResults(null);
     	  return new ResponseEntity<CustomResponse>(CustomResponse, HttpStatus.BAD_REQUEST);  
      	  
        }
      	  
          CustomResponse.setStatus("Success");
          CustomResponse.setStatusCode(200);;
          CustomResponse.setMessage("TrackRide Found");
          CustomResponse.setResults(trackRide);
    	     return CustomResponse;
          }
       
       
    /**
     * {@code GET  /track-rides/:id} : get the "id" trackRide.
     *
     * @param id the id of the trackRide to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the trackRide, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/trackRides/{id}")
   // @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object getTrackRide(@PathVariable String id) {
        log.debug("REST request to get TrackRide : {}", id);
       
        Optional<TrackRide> trackRide = trackRideService.findOne(id);
        CustomResponse CustomResponse=new CustomResponse();
        
        
        if(trackRide==null)
        {
     	   CustomResponse.setStatus("Failure");
     	   CustomResponse.setStatusCode(404);
     	   CustomResponse.setMessage("TrackRide not Found");
      	   CustomResponse.setResults(null);
     	  return new ResponseEntity<CustomResponse>(CustomResponse, HttpStatus.BAD_REQUEST);  
      	  
        }
      	  
          CustomResponse.setStatus("Success");
          CustomResponse.setStatusCode(200);;
          CustomResponse.setMessage("TrackRide Found");
          CustomResponse.setResults(trackRide);
    	  return CustomResponse;
          }
        

    /**
     * {@code DELETE  /track-rides/:id} : delete the "id" trackRide.
     *
     * @param id the id of the trackRide to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @SuppressWarnings("unused")
	@DeleteMapping("/trackRides/{bookingId}")
  //  @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object deleteTrackRide(@PathVariable String bookingId) {
        log.debug("REST request to delete TrackRide : {}", bookingId);
        
        CustomResponse CustomResponse=new CustomResponse();

        TrackRide trackRide =trackRideService.findByBookingId(bookingId);
        String id=trackRide.getId();
        
    	if(trackRide==null)
    	{
    	 CustomResponse.setStatusCode(404);
    	 CustomResponse.setStatus("Failure");
   		 CustomResponse.setMessage("TrackRide not Found");
   		 return new ResponseEntity<>(CustomResponse,HttpStatus.NOT_FOUND);
    	}
    	
    	try
    	{
    		trackRideService.delete(id);
    	}
    	catch(Exception e)
    	{
    
    		 CustomResponse.setStatus("Failure");
     		 CustomResponse.setMessage("TrackRide not Deleted");
     		 return new ResponseEntity<>(CustomResponse,HttpStatus.BAD_REQUEST);
		}
    	    CustomResponse.setStatusCode(200);
    		CustomResponse.setStatus("Success");
    		CustomResponse.setMessage("TrackRide Deleted");
    		return CustomResponse;
    	
}
      
}
