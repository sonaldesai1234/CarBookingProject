package com.mycipl.web.rest;

import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.hazelcast.com.eclipsesource.json.ParseException;
import com.mycipl.domain.CityCollection;
import com.mycipl.domain.CustomResponse;
import com.mycipl.domain.NotificationCollection;
import com.mycipl.repository.NotificationCollectionRepository;
import com.mycipl.security.AuthoritiesConstants;
import com.mycipl.service.NotificationCollectionService;
import com.mycipl.web.rest.errors.BadRequestAlertException;

/**
 * REST controller for managing {@link com.mycipl.domain.NotificationCollection}.
 */
@RestController
@RequestMapping("/api")
public class NotificationCollectionResource {

    private final Logger log = LoggerFactory.getLogger(NotificationCollectionResource.class);

    private static final String ENTITY_NAME = "notificationCollection";


    @Autowired
    NotificationCollectionRepository notificationCollectionRepository;
    
    private final NotificationCollectionService notificationCollectionService;
    
    CustomResponse customResponse=new CustomResponse();

    public NotificationCollectionResource(NotificationCollectionService notificationCollectionService) {
        this.notificationCollectionService = notificationCollectionService;
    }

    /**
     * {@code POST  /notification-collections} : Create a new notificationCollection.
     *
     * @param notificationCollection the notificationCollection to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new notificationCollection, or with status {@code 400 (Bad Request)} if the notificationCollection has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/notification")
    //@Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})

    public Object createNotificationCollection(@Valid @RequestBody NotificationCollection notificationCollection) throws URISyntaxException {
        log.debug("REST request to save NotificationCollection : {}", notificationCollection);
        if (notificationCollection.getId() != null) {
            throw new BadRequestAlertException("A new notificationCollection cannot already have an ID", ENTITY_NAME, "idexists");
        }
		

       	 if(notificationCollection.getTo()==null)

        {
       		customResponse.setStatus("Failure");
       		customResponse.setStatusCode(404);
       		customResponse.setMessage("to Dse is null");
      	     	
      	   return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.BAD_REQUEST);  
        }
      	  
        if(notificationCollection.getMessage().isEmpty())
        {
        	customResponse.setStatus("Failure");
        	customResponse.setStatusCode(404);
        	customResponse.setMessage("Message is null");
        	     	
        	return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.BAD_REQUEST);  
        } else
      	 
        {
          NotificationCollection result = notificationCollectionService.save(notificationCollection);
          customResponse.setStatus("Success");
          customResponse.setStatusCode(200);
          customResponse.setMessage("Notification created");
          customResponse.setResults(result);
    	  
    	  return customResponse;
        } 
       
       
        
    }

    /**
     * {@code PUT  /notification-collections} : Updates an existing notificationCollection.
     *
     * @param notificationCollection the notificationCollection to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated notificationCollection,
     * or with status {@code 400 (Bad Request)} if the notificationCollection is not valid,
     * or with status {@code 500 (Internal Server Error)} if the notificationCollection couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/notification")
    //@Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})

    public Object updateNotificationCollection(@RequestBody NotificationCollection notificationCollection) throws URISyntaxException {
        log.debug("REST request to update NotificationCollection : {}", notificationCollection);
        if (notificationCollection.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
          
                
       if(notificationCollection.getTo()==null)
       {
     		customResponse.setStatus("Failure");
     		customResponse.setStatusCode(404);
     		customResponse.setMessage("to Dse is null");
     	     	
     	   return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.BAD_REQUEST);  
       }
     	  
       else if(notificationCollection.getMessage()==null)
       {
    	   	customResponse.setStatus("Failure");
    	   	customResponse.setStatusCode(404);
    	   	customResponse.setMessage("Message is null");
       	     	
       	return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.BAD_REQUEST);  
       } else
     	 
       {
         NotificationCollection result = notificationCollectionService.save(notificationCollection);
         customResponse.setStatus("Success");
         customResponse.setStatusCode(200);
         customResponse.setMessage("Notification Updated");
         customResponse.setResults(result);
   	  
   	     return customResponse;
       } 
      
       
    }

    /**
     * {@code GET  /notification-collections} : get all the notificationCollections.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of notificationCollections in body.
     */
   
    @GetMapping("/notification")

   
    //@Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})

    public Object getAllNotificationCollections() {
        log.debug("REST request to get all NotificationCollections");
        List<NotificationCollection> notificationCollection= notificationCollectionService.findAll();
       
      	
      	 if(notificationCollection.isEmpty())
        {
      		customResponse.setStatus("Failure");
      		customResponse.setStatusCode(404);
      		customResponse.setMessage("Notification Not Found");
      	  
      		customResponse.setResults(null);
      	  return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);  
      	  
      	  
        }
          
      	 
      	customResponse.setStatus("Success");
      	customResponse.setStatusCode(200);
      	customResponse.setMessage("Notification Found");
      	customResponse.setResults(notificationCollection);
    	  
    	  return customResponse;
          
       
    }

    /**
     * {@code GET  /notification-collections/:id} : get the "id" notificationCollection.
     *
     * @param id the id of the notificationCollection to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the notificationCollection, or with status {@code 404 (Not Found)}.
     */
   
    @GetMapping("/notification/{id}")
   // @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object getNotificationCollection(@PathVariable String id) {
        log.debug("REST request to get NotificationCollection : {}", id);
        
        NotificationCollection notificationCollection = notificationCollectionService.findOneById(id);
       
     	
        if(notificationCollection==null)
       {
        	customResponse.setStatus("Failure");
        	customResponse.setStatusCode(404);
        	customResponse.setMessage("Notification Not Found");
        	customResponse.setResults(null);
     	     return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);  
     	 
       }
         
     	 
        	customResponse.setStatus("Success");
        	customResponse.setStatusCode(200);
        	customResponse.setMessage("Notification Found");
        	customResponse.setResults(notificationCollection);
   	     	return customResponse;
         
        
    }
    
    
   //display or send noti to +4 sendingDate n -4 sendingDate.......
    @GetMapping("/notificationByDate/{to}/{sendingDate}")
   // @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object getNotificationList(@PathVariable String to,@PathVariable Instant sendingDate) throws java.text.ParseException
    {
    	
    	log.debug("get request to get all notification-collections by date");
		ArrayList<String> str=new ArrayList<String>();
		str.add(to);
		if(to==null||sendingDate==null||"".equalsIgnoreCase(to)) { throw new
		 BadRequestAlertException("Invalid Value", ENTITY_NAME,
		 "To And sendingDate cant be null");
		}
		 
    	
		 Instant  instantstart = Instant .parse(sendingDate.toString());  
    	 instantstart = instantstart.minus(Duration.ofDays(4));  
    	 System.out.println(instantstart);
    	 Instant  endinstant = Instant .parse(sendingDate.toString());  
    	 endinstant = endinstant.plus(Duration.ofDays(4)); 
    	 System.out.println(endinstant);
    	
		List<NotificationCollection> notificationCollection =notificationCollectionService.findByToAndSendingDateBetween(to,instantstart, endinstant);
		
        if(notificationCollection.isEmpty())
        {
        	customResponse.setStatus("Failure");
        	customResponse.setStatusCode(404);
        	customResponse.setMessage("Notification Not Found");
     	  
        	customResponse.setResults(null);
     	  return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);  
     	   	  
       }
   	 
        customResponse.setStatus("Success");
        customResponse.setStatusCode(200);
        customResponse.setMessage("Notification Found");
        customResponse.setResults(notificationCollection);
 	  
 	  return customResponse;
       
    
    }
    	

    /**
     * {@code DELETE  /notification-collections/:id} : delete the "id" notificationCollection.
     *
     * @param id the id of the notificationCollection to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @SuppressWarnings("unused")
	@DeleteMapping("/notification/{id}")
    //@Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object deleteNotificationCollection(@PathVariable String id) {
        log.debug("REST request to delete NotificationCollection : {}", id);
       
      
  NotificationCollection notificationCollection =notificationCollectionService.findOneById(id);
  
  String id1=notificationCollection.getId();
        
    	if(notificationCollection == null)
    		
    	{
    		 customResponse.setStatus("Failure");
       		 customResponse.setMessage("Notification Not Found");
       		 return new ResponseEntity<>(customResponse,HttpStatus.NOT_FOUND);
    		
    	}
    	
    	try
    	{
    		notificationCollectionService.delete(id1);
    	}
    	catch(Exception e)
    	{
    		
    		 customResponse.setStatus("Failure");
    		 customResponse.setMessage("Notification Not deleted");
    		 return new ResponseEntity<>(customResponse,HttpStatus.BAD_REQUEST);
    	}
    	
    	
    		customResponse.setStatus("Success");
    		customResponse.setMessage("Notification deleted");
    		customResponse.setResults(null);
    		return customResponse;
    	}
       
    }
    
    

