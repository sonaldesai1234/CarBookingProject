package com.mycipl.web.rest;

import java.net.URI;
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

import com.mycipl.domain.CustomResponse;
import com.mycipl.domain.NotificationSchedulerCollection;
import com.mycipl.domain.OtpCollection;
import com.mycipl.security.AuthoritiesConstants;
import com.mycipl.service.NotificationSchedulerCollectionService;
import com.mycipl.web.rest.errors.BadRequestAlertException;
import com.mycipl.web.rest.util.HeaderUtil;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycipl.domain.NotificationSchedulerCollection}.
 */
@RestController
@RequestMapping("/api")
public class NotificationSchedulerCollectionResource {

    private final Logger log = LoggerFactory.getLogger(NotificationSchedulerCollectionResource.class);

    private static final String ENTITY_NAME = "notificationSchedulerCollection";


    private final NotificationSchedulerCollectionService notificationSchedulerCollectionService;

    public NotificationSchedulerCollectionResource(NotificationSchedulerCollectionService notificationSchedulerCollectionService) {
        this.notificationSchedulerCollectionService = notificationSchedulerCollectionService;
    }

    /**
     * {@code POST  /notification-scheduler-collections} : Create a new notificationSchedulerCollection.
     *
     * @param notificationSchedulerCollection the notificationSchedulerCollection to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new notificationSchedulerCollection, or with status {@code 400 (Bad Request)} if the notificationSchedulerCollection has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/notification-scheduler")
   // @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object createNotificationSchedulerCollection(@RequestBody NotificationSchedulerCollection notificationSchedulerCollection) throws URISyntaxException {
        log.debug("REST request to save NotificationSchedulerCollection : {}", notificationSchedulerCollection);
        if (notificationSchedulerCollection.getId() != null) {
            throw new BadRequestAlertException("A new notificationSchedulerCollection cannot already have an ID", ENTITY_NAME, "idexists");
        }
        
        CustomResponse  CustomResponse = new CustomResponse();
        
        if(notificationSchedulerCollection.getDseLoginId()==null&& notificationSchedulerCollection.getMessage()==null && notificationSchedulerCollection.getTitle()==null)
        {
     	   CustomResponse.setStatus("Failure");
     	   CustomResponse.setStatusCode(404);
     	   CustomResponse.setMessage("Dse Login Id or Message or Title is Null"); 
     	   CustomResponse.setResults(null);
      	  return new ResponseEntity<CustomResponse>(CustomResponse, HttpStatus.NOT_FOUND);  
      	  
      	  
        }
        CustomResponse.setStatus("Success");
        CustomResponse.setStatusCode(200);
        CustomResponse.setMessage("NotificationScheduler Created");
        NotificationSchedulerCollection result = notificationSchedulerCollectionService.save(notificationSchedulerCollection);
        CustomResponse.setResults(result);
  	  
  	     return CustomResponse;
        }
        
       
    /**
     * {@code PUT  /notification-scheduler-collections} : Updates an existing notificationSchedulerCollection.
     *
     * @param notificationSchedulerCollection the notificationSchedulerCollection to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated notificationSchedulerCollection,
     * or with status {@code 400 (Bad Request)} if the notificationSchedulerCollection is not valid,
     * or with status {@code 500 (Internal Server Error)} if the notificationSchedulerCollection couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/notification-scheduler")
    //@Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object updateNotificationSchedulerCollection(@RequestBody NotificationSchedulerCollection notificationSchedulerCollection) throws URISyntaxException {
        log.debug("REST request to update NotificationSchedulerCollection : {}", notificationSchedulerCollection);
        if (notificationSchedulerCollection.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        
        CustomResponse  CustomResponse = new CustomResponse();
        
        if(notificationSchedulerCollection.getDseLoginId()==null&& notificationSchedulerCollection.getMessage()==null && notificationSchedulerCollection.getTitle()==null)
        {
     	   CustomResponse.setStatus("Failure");
     	   CustomResponse.setStatusCode(404);
     	   CustomResponse.setMessage("Dse Login Id or Message or Title is Null"); 
     	   CustomResponse.setResults(null);
      	  return new ResponseEntity<CustomResponse>(CustomResponse, HttpStatus.NOT_FOUND);  
      	  
      	  
        }
        CustomResponse.setStatus("Success");
        CustomResponse.setStatusCode(200);
        CustomResponse.setMessage("NotificationScheduler Created");
        NotificationSchedulerCollection result = notificationSchedulerCollectionService.save(notificationSchedulerCollection);
        CustomResponse.setResults(result);
  	  
  	     return CustomResponse;
        }
        
        
    /**
     * {@code GET  /notification-scheduler-collections} : get all the notificationSchedulerCollections.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of notificationSchedulerCollections in body.
     */
    @GetMapping("/notification-scheduler")
    //@Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object getAllNotificationSchedulerCollections() {
        log.debug("REST request to get all NotificationSchedulerCollections");
        
        CustomResponse  CustomResponse = new CustomResponse();
        List<NotificationSchedulerCollection> notificationSchedulerCollection =notificationSchedulerCollectionService.findAll();
        
        if(notificationSchedulerCollection.isEmpty())
        {
     	   CustomResponse.setStatus("Failure");
     	   CustomResponse.setStatusCode(404);
     	   CustomResponse.setMessage("Notification Scheduler Not Found"); 
     	   CustomResponse.setResults(null);
      	   return new ResponseEntity<CustomResponse>(CustomResponse, HttpStatus.NOT_FOUND);  
      	  
      	  
        }
        CustomResponse.setStatus("Success");
        CustomResponse.setStatusCode(200);
        CustomResponse.setMessage("Notification Scheduler  Created");
        CustomResponse.setResults(notificationSchedulerCollection);
  	  
  	     return CustomResponse;
        }
        
       
    

    /**
     * {@code GET  /notification-scheduler-collections/:id} : get the "id" notificationSchedulerCollection.
     *
     * @param id the id of the notificationSchedulerCollection to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the notificationSchedulerCollection, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/notification-scheduler/{id}")
    //@Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object getNotificationSchedulerCollection(@PathVariable String id) {
        log.debug("REST request to get NotificationSchedulerCollection : {}", id);
        CustomResponse  CustomResponse = new CustomResponse();
        Optional<NotificationSchedulerCollection> notificationSchedulerCollection = notificationSchedulerCollectionService.findOne(id);
        
        if(notificationSchedulerCollection== null)
        {
     	   CustomResponse.setStatus("Failure");
     	   CustomResponse.setStatusCode(404);
     	   CustomResponse.setMessage("Notification Scheduler Not Found"); 
     	   CustomResponse.setResults(null);
      	   return new ResponseEntity<CustomResponse>(CustomResponse, HttpStatus.NOT_FOUND);  
      	  
      	  
        }
        CustomResponse.setStatus("Success");
        CustomResponse.setStatusCode(200);
        CustomResponse.setMessage("Notification Scheduler  Found");
        CustomResponse.setResults(notificationSchedulerCollection);
  	  
  	     return CustomResponse;
        }
        
       

    /**
     * {@code DELETE  /notification-scheduler-collections/:id} : delete the "id" notificationSchedulerCollection.
     *
     * @param id the id of the notificationSchedulerCollection to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/notification-scheduler/{id}")
   // @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object deleteNotificationSchedulerCollection(@PathVariable String id) {
        log.debug("REST request to delete NotificationSchedulerCollection : {}", id);
        
        CustomResponse customResponse = new CustomResponse();
        Optional<NotificationSchedulerCollection> notificationSchedulerCollection = notificationSchedulerCollectionService.findOne(id);
    	if(notificationSchedulerCollection == null)
    		
    	{
    		 customResponse.setStatus("Failure");
       		 customResponse.setMessage("Notification Scheduler Not found");
       		 return new ResponseEntity<>(customResponse,HttpStatus.NOT_FOUND);
    		
    	}
    	try
    	{
    		notificationSchedulerCollectionService.delete(id);
    	}
    	catch(Exception e)
    	{
    		
    		 customResponse.setStatus("Failure");
    		 customResponse.setMessage("Notification Scheduler Not deleted");
    		 return new ResponseEntity<>(customResponse,HttpStatus.BAD_REQUEST);
    	}
    		customResponse.setStatus("Success");
    		customResponse.setMessage("Notification Scheduler deleted");
    		return customResponse;
    	}
       
        
    
   
}
