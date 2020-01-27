package com.mycipl.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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
import com.mycipl.domain.NotificationCollection;
import com.mycipl.domain.OtpCollection;
import com.mycipl.security.AuthoritiesConstants;
import com.mycipl.service.OtpCollectionService;
import com.mycipl.web.rest.errors.BadRequestAlertException;
import com.mycipl.web.rest.util.HeaderUtil;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycipl.domain.OtpCollection}.
 */
@RestController
@RequestMapping("/api")
public class OtpCollectionResource {

    private final Logger log = LoggerFactory.getLogger(OtpCollectionResource.class);

    private static final String ENTITY_NAME = "otpCollection";


    private final OtpCollectionService otpCollectionService;

    public OtpCollectionResource(OtpCollectionService otpCollectionService) {
        this.otpCollectionService = otpCollectionService;
    }

    /**
     * {@code POST  /otp-collections} : Create a new otpCollection.
     *
     * @param otpCollection the otpCollection to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new otpCollection, or with status {@code 400 (Bad Request)} if the otpCollection has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/otp")
    //@Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object createOtpCollection(@RequestBody OtpCollection otpCollection) throws URISyntaxException {
        log.debug("REST request to save OtpCollection : {}", otpCollection);
        if (otpCollection.getId() != null) {
            throw new BadRequestAlertException("A new otpCollection cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CustomResponse  CustomResponse = new CustomResponse();
        
        if(otpCollection.getOtp()==null&& otpCollection.getDseLoginId()==null)
        {
     	   CustomResponse.setStatus("Failure");
     	   CustomResponse.setStatusCode(404);
     	   CustomResponse.setMessage("OTP Not Created"); 
     	   CustomResponse.setResults(null);
      	  return new ResponseEntity<CustomResponse>(CustomResponse, HttpStatus.NOT_FOUND);  
      	  
      	  
        }
        CustomResponse.setStatus("Success");
        CustomResponse.setStatusCode(200);
        CustomResponse.setMessage("OTP Created");
        OtpCollection result = otpCollectionService.save(otpCollection);
        CustomResponse.setResults(result);
  	  
  	     return CustomResponse;
        }
       
      
    /**
     * {@code PUT  /otp-collections} : Updates an existing otpCollection.
     *
     * @param otpCollection the otpCollection to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated otpCollection,
     * or with status {@code 400 (Bad Request)} if the otpCollection is not valid,
     * or with status {@code 500 (Internal Server Error)} if the otpCollection couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/otp")
   // @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object updateOtpCollection(@RequestBody OtpCollection otpCollection) throws URISyntaxException {
        log.debug("REST request to update OtpCollection : {}", otpCollection);
        if (otpCollection.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        
          CustomResponse  CustomResponse = new CustomResponse();
        
        if(otpCollection.getOtp()==null&& otpCollection.getDseLoginId()==null)
        {
     	   CustomResponse.setStatus("Failure");
     	   CustomResponse.setStatusCode(404);
     	   CustomResponse.setMessage("OTP Not Updated"); 
     	   CustomResponse.setResults(null);
      	  return new ResponseEntity<CustomResponse>(CustomResponse, HttpStatus.NOT_FOUND);  
      	  
      	  
        }
        else
        {
        CustomResponse.setStatus("Success");
        CustomResponse.setStatusCode(200);
        CustomResponse.setMessage("OTP Updated");
        OtpCollection result = otpCollectionService.save(otpCollection);
        CustomResponse.setResults(result);
  	  
  	     return CustomResponse;
        }
    }
       
    /**
     * {@code GET  /otp-collections} : get all the otpCollections.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of otpCollections in body.
     */
    @GetMapping("/otp")
    //@Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object getAllOtpCollections() {
        log.debug("REST request to get all OtpCollections");
              List<OtpCollection>  otpCollection =   otpCollectionService.findAll();
              CustomResponse  CustomResponse = new CustomResponse();
        if(otpCollection.isEmpty())
        {
     	   CustomResponse.setStatus("Failure");
     	   CustomResponse.setStatusCode(404);
     	   CustomResponse.setMessage("OTP Not Found"); 
     	   CustomResponse.setResults(null);
      	  return new ResponseEntity<CustomResponse>(CustomResponse, HttpStatus.NOT_FOUND);  
      	  
      	  
        }
        CustomResponse.setStatus("Success");
        CustomResponse.setStatusCode(200);
        CustomResponse.setMessage("OTP Found");
        CustomResponse.setResults(otpCollection);
  	  
  	     return CustomResponse;
       
        }
    
    

    
    @GetMapping("/otpByDseLoginId/{dseLoginId}")
    //@Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object getAllOtp(@PathVariable String dseLoginId) {
        log.debug("REST request to get all OtpCollections");
    
              OtpCollection  otpCollectionForDse =   otpCollectionService.findOneByDseLoginId(dseLoginId);
             
              CustomResponse  CustomResponse = new CustomResponse();
              
              Random rand = new Random();

              String otp = String.format("%04d", rand.nextInt(10000));

              OtpCollection otpCollection = new OtpCollection();
              otpCollection.setDseLoginId(dseLoginId);
              otpCollection.setOtp(otp);
              
              OtpCollection otpCollectionObj=null;
              
              if(otpCollectionForDse==null)
              {	
            	  otpCollectionObj= otpCollectionService.save(otpCollection);
            	 
              }
              else
            	{
            	  otpCollectionForDse.setOtp(otp);
            	  otpCollectionObj= otpCollectionService.save(otpCollectionForDse);
             }
              
        if(dseLoginId.isEmpty())
        {
     	   CustomResponse.setStatus("Failure");
     	   CustomResponse.setStatusCode(404);
     	   CustomResponse.setMessage("OTP Not Found"); 
     	   CustomResponse.setResults(null);
      	  return new ResponseEntity<CustomResponse>(CustomResponse, HttpStatus.NOT_FOUND);  
      	  
      	  
        }
        CustomResponse.setStatus("Success");
        CustomResponse.setStatusCode(200);
        CustomResponse.setMessage("OTP Found");
        CustomResponse.setResults(otpCollectionObj.getOtp());
  	  
  	     return CustomResponse;
       
        }
    
    
    
    @GetMapping("/otpVerify/{dseLoginId}/{otp}")
    //@Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object getOtpVerify(@PathVariable String dseLoginId,@PathVariable String otp) {
        log.debug("REST request to get all OtpCollections");
    
              OtpCollection  otpCollection =   otpCollectionService.findByDseLoginIdAndOtp(dseLoginId,otp);
              
             
             
              
              CustomResponse  customResponse = new CustomResponse();
            
           
              
        if(otpCollection==null)
        {
        	customResponse.setStatus("Failure");
        	customResponse.setStatusCode(404);
        	customResponse.setMessage("OTP Not Found"); 
        	customResponse.setResults(null);
      	    return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);  
      	  
      	  
        }
        customResponse.setStatus("Success");
        customResponse.setStatusCode(200);
        customResponse.setMessage("OTP Found");
        if(otpCollection.getOtp().equals(otp))
        {
        	customResponse.setResults("OTP Verify");
        }
  	     return customResponse;
       
        }
    
    
    
    
    
    

    /**
     * {@code GET  /otp-collections/:id} : get the "id" otpCollection.
     *
     * @param id the id of the otpCollection to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the otpCollection, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/otp/{id}")
    //@Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object getOtpCollection(@PathVariable String id) {
        log.debug("REST request to get OtpCollection : {}", id);
        Optional<OtpCollection> otpCollection = otpCollectionService.findOne(id);
        
       
        CustomResponse  CustomResponse = new CustomResponse();
       if(otpCollection==null)
       {
	   CustomResponse.setStatus("Failure");
	   CustomResponse.setStatusCode(404);
	   CustomResponse.setMessage("OTP Not Found"); 
	   CustomResponse.setResults(null);
	   return new ResponseEntity<CustomResponse>(CustomResponse, HttpStatus.NOT_FOUND);  
	  
	  
          }
       	CustomResponse.setStatus("Success");
       	CustomResponse.setStatusCode(200);
       	CustomResponse.setMessage("OTP Found");
       	CustomResponse.setResults(otpCollection);
  
     return CustomResponse;
 
  }
     

    /**
     * {@code DELETE  /otp-collections/:id} : delete the "id" otpCollection.
     *
     * @param id the id of the otpCollection to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
        @DeleteMapping("/otp/{id}")
       // @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
        public Object deleteOtpCollection(@PathVariable String id) {
        log.debug("REST request to delete OtpCollection : {}", id);
        
        CustomResponse customResponse = new CustomResponse();
        Optional<OtpCollection> otpCollection =otpCollectionService.findOne(id);
        
    	if(otpCollection == null)
    		
    	{
    		 customResponse.setStatus("Failure");
       		 customResponse.setMessage("OTP Not found");
       		 return new ResponseEntity<>(customResponse,HttpStatus.NOT_FOUND);
    		
    	}
    	try
    	{
    		otpCollectionService.delete(id);
    	}
    	catch(Exception e)
    	{
    		
    		 customResponse.setStatus("Failure");
    		 customResponse.setMessage("OTP Not deleted");
    		 return new ResponseEntity<>(customResponse,HttpStatus.BAD_REQUEST);
    	}
    	customResponse.setStatus("Success");
		customResponse.setMessage("OTP deleted");
	     return customResponse;
    	}
       
    }

