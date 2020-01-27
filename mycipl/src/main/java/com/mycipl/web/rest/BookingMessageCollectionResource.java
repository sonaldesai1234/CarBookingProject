package com.mycipl.web.rest;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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

import com.mycipl.domain.BookingMessageCollection;
import com.mycipl.domain.CustomResponse;
import com.mycipl.security.AuthoritiesConstants;
import com.mycipl.service.BookingMessageCollectionService;
import com.mycipl.web.rest.errors.BadRequestAlertException;

/**
 * REST controller for managing {@link com.mycipl.domain.BookingMessageCollection}.
 */
@RestController
@RequestMapping("/api")
public class BookingMessageCollectionResource {

    private final Logger log = LoggerFactory.getLogger(BookingMessageCollectionResource.class);

    private static final String ENTITY_NAME = "bookingMessageCollection";

    
    CustomResponse CustomResponse=new CustomResponse();

    private final BookingMessageCollectionService bookingMessageCollectionService;

    public BookingMessageCollectionResource(BookingMessageCollectionService bookingMessageCollectionService) {
        this.bookingMessageCollectionService = bookingMessageCollectionService;
    }

    /**
     * {@code POST  /booking-message-collections} : Create a new bookingMessageCollection.
     *
     * @param bookingMessageCollection the bookingMessageCollection to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new bookingMessageCollection, or with status {@code 400 (Bad Request)} if the bookingMessageCollection has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @SuppressWarnings("unused")
	@PostMapping("/bookingMessage")
    //@Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object createBookingMessageCollection(@RequestBody BookingMessageCollection bookingMessageCollection) throws URISyntaxException {
        log.debug("REST request to save BookingMessageCollection : {}", bookingMessageCollection);
        if (bookingMessageCollection.getId() != null) {
            throw new BadRequestAlertException("A new bookingMessageCollection cannot already have an ID", ENTITY_NAME, "idexists");
        }
       
        
        BookingMessageCollection result = bookingMessageCollectionService.save(bookingMessageCollection);


        if(bookingMessageCollection.getCarModelName()==null||bookingMessageCollection.getDseLoginID()==null||bookingMessageCollection.getDseNumber()==null||
        		bookingMessageCollection.getTo()==null)
        {
      	  CustomResponse.setStatus("Failure");
      	  CustomResponse.setStatusCode(404);
      	  CustomResponse.setMessage("BookingMessage Not Created");
      	  CustomResponse.setResults(null);
      	  return new ResponseEntity<CustomResponse>(CustomResponse, HttpStatus.NOT_FOUND);  
      	
      	        	  
        }
        CustomResponse.setStatus("Success");
        CustomResponse.setStatusCode(200);
        CustomResponse.setMessage("BookingMessage Created");
        CustomResponse.setResults(result);
   	  
        return CustomResponse;
        }
        
        
    /**
     * {@code PUT  /booking-message-collections} : Updates an existing bookingMessageCollection.
     *
     * @param bookingMessageCollection the bookingMessageCollection to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated bookingMessageCollection,
     * or with status {@code 400 (Bad Request)} if the bookingMessageCollection is not valid,
     * or with status {@code 500 (Internal Server Error)} if the bookingMessageCollection couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/bookingMessage")
    //@Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object updateBookingMessageCollection(@RequestBody BookingMessageCollection bookingMessageCollection) throws URISyntaxException {
        log.debug("REST request to update BookingMessageCollection : {}", bookingMessageCollection);
      

        if (bookingMessageCollection.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
       
        if(bookingMessageCollection.getCarModelName()==null||bookingMessageCollection.getDseLoginID()==null||bookingMessageCollection.getDseNumber()==null||
        		bookingMessageCollection.getTo()==null)
        {
      	  CustomResponse.setStatus("Failure");
      	  CustomResponse.setStatusCode(404);
      	  CustomResponse.setMessage("BookingMessageCollection Not Updated");
      	  CustomResponse.setResults(null);
      	  return new ResponseEntity<CustomResponse>(CustomResponse, HttpStatus.NOT_FOUND);  
      	        	  
        }
        BookingMessageCollection result = bookingMessageCollectionService.save(bookingMessageCollection);
        CustomResponse.setStatus("Success");
        CustomResponse.setStatusCode(200);
        CustomResponse.setMessage("BookingMessageCollection Updated");
        CustomResponse.setResults(result);
   	  
        return CustomResponse;
        }
        
       
    /**
     * {@code GET  /booking-message-collections} : get all the bookingMessageCollections.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of bookingMessageCollections in body.
     */
    @GetMapping("/bookingMessage")
   // @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object getAllBookingMessageCollections() {
        log.debug("REST request to get all BookingMessageCollections");
        List<BookingMessageCollection> result =bookingMessageCollectionService.findAll();
        if(result.isEmpty())
        {
      	  CustomResponse.setStatus("Failure");
      	  CustomResponse.setStatusCode(404);
      	  CustomResponse.setMessage("BookingMessageCollection Not Found");
      	  CustomResponse.setResults(null);
      	  return new ResponseEntity<CustomResponse>(CustomResponse, HttpStatus.NOT_FOUND);  
      	        	  
        }
        CustomResponse.setStatus("Success");
        CustomResponse.setStatusCode(200);
        CustomResponse.setMessage("BookingMessageCollection Found");
        CustomResponse.setResults(result);
   	  
   	  	return CustomResponse;
        }
       
    /**
     * {@code GET  /booking-message-collections/:id} : get the "id" bookingMessageCollection.
     *
     * @param id the id of the bookingMessageCollection to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the bookingMessageCollection, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/bookingMessage/{id}")
  //  @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object getBookingMessageCollection(@PathVariable String id) {
        log.debug("REST request to get BookingMessageCollection : {}", id);
        List<BookingMessageCollection> bookingMessageCollection = bookingMessageCollectionService.findOneById(id);
        if(bookingMessageCollection.isEmpty())
        {
      	  CustomResponse.setStatus("Failure");
      	  CustomResponse.setStatusCode(404);
      	  CustomResponse.setMessage("BookingMessageCollection Not Found");
      	  CustomResponse.setResults(null);
      	  return new ResponseEntity<CustomResponse>(CustomResponse, HttpStatus.NOT_FOUND);  
      	        	  
        }
        CustomResponse.setStatus("Success");
        CustomResponse.setStatusCode(200);
        CustomResponse.setMessage("BookingMessageCollection Found");
        CustomResponse.setResults(bookingMessageCollection);
   	  
   	  	return CustomResponse;
        }
        
      /**
     * {@code DELETE  /booking-message-collections/:id} : delete the "id" bookingMessageCollection.
     *
     * @param id the id of the bookingMessageCollection to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/bookingMessage/{id}")
   // @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object deleteBookingMessageCollection(@PathVariable String id) {
        log.debug("REST request to delete BookingMessageCollection : {}", id);
        List<BookingMessageCollection> bookingMessageCollection = bookingMessageCollectionService.findOneById(id);

    	if(bookingMessageCollection.isEmpty())
    	{
    		 CustomResponse.setStatus("Failure");
      		 CustomResponse.setMessage("BookingMessageCollection not found");
      		 return new ResponseEntity<>(CustomResponse,HttpStatus.NOT_FOUND);
    	}
    	

    	try
    	{
        	bookingMessageCollectionService.delete(id);
	
    	}    
    	catch (Exception e) {
    		 CustomResponse.setStatus("Failure");
      		 CustomResponse.setMessage("BookingMessageCollection not deleted");
      		 return new ResponseEntity<>(CustomResponse,HttpStatus.BAD_REQUEST);
		}
    	
        CustomResponse.setStatus("Success");
        CustomResponse.setMessage("BookingMessageCollection deleted");
        return CustomResponse;
    		 
    	}
    	
	}
    
   
