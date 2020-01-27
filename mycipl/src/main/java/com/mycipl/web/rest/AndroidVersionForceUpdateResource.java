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

import com.mycipl.domain.AndroidVersionForceUpdate;
import com.mycipl.domain.CarBookingsCollection;
import com.mycipl.domain.CustomResponse;
import com.mycipl.domain.UserProfile;
import com.mycipl.security.AuthoritiesConstants;
import com.mycipl.service.AndroidVersionForceUpdateService;
import com.mycipl.web.rest.errors.BadRequestAlertException;
import com.mycipl.web.rest.util.HeaderUtil;

/**
 * REST controller for managing {@link com.mycipl.domain.AndroidVersionForceUpdate}.
 */
@RestController
@RequestMapping("/api")
public class AndroidVersionForceUpdateResource {

    private final Logger log = LoggerFactory.getLogger(AndroidVersionForceUpdateResource.class);

    private static final String ENTITY_NAME = "androidVersionForceUpdate";


    private final AndroidVersionForceUpdateService androidVersionForceUpdateService;
    
    CustomResponse customResponse=new CustomResponse();

    public AndroidVersionForceUpdateResource(AndroidVersionForceUpdateService androidVersionForceUpdateService) {
        this.androidVersionForceUpdateService = androidVersionForceUpdateService;
    }

    /**
     * {@code POST  /android-version-force-updates} : Create a new androidVersionForceUpdate.
     *
     * @param androidVersionForceUpdate the androidVersionForceUpdate to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new androidVersionForceUpdate, or with status {@code 400 (Bad Request)} if the androidVersionForceUpdate has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @SuppressWarnings("unused")
	@PostMapping("/androidVersionForceUpdates")
   // @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object createAndroidVersionForceUpdate(@RequestBody AndroidVersionForceUpdate androidVersionForceUpdate) throws URISyntaxException {
        log.debug("REST request to save AndroidVersionForceUpdate : {}", androidVersionForceUpdate);
       if (androidVersionForceUpdate.getId() != null)
       {
            throw new BadRequestAlertException("A new androidVersionForceUpdate cannot already have an ID", ENTITY_NAME, "idexists");
            
        }
   
 	   if(androidVersionForceUpdate.getVersionName()==null)

        {

        	customResponse.setStatus("Failure");
        	customResponse.setStatusCode(404);
        	customResponse.setMessage("androidVersionForceUpdate Not Created");
        	customResponse.setResults(null);
      	  	return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);  

      	        	  
        }
       	AndroidVersionForceUpdate result = androidVersionForceUpdateService.save(androidVersionForceUpdate);
       	customResponse.setStatus("Success");
        customResponse.setStatusCode(200);
        customResponse.setMessage("androidVersionForceUpdate Created");
       	customResponse.setResults(result);
       	System.out.println("***********************"+result);
       	return customResponse;
       
    }
        
             

    /**
     * {@code PUT  /android-version-force-updates} : Updates an existing androidVersionForceUpdate.
     *
     * @param androidVersionForceUpdate the androidVersionForceUpdate to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated androidVersionForceUpdate,
     * or with status {@code 400 (Bad Request)} if the androidVersionForceUpdate is not valid,
     * or with status {@code 500 (Internal Server Error)} if the androidVersionForceUpdate couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @SuppressWarnings("unused")
	@PutMapping("/androidVersionForceUpdates")
    //@Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object updateAndroidVersionForceUpdate(@RequestBody AndroidVersionForceUpdate androidVersionForceUpdate) throws URISyntaxException {
    
    	if(androidVersionForceUpdate.getId()==null)
    	{
    		
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");

    	}
    	String id=androidVersionForceUpdate.getId();
    	AndroidVersionForceUpdate androidVersionForceUpdateObj = androidVersionForceUpdateService.findOneById(id);
    	 if(androidVersionForceUpdateObj.getId()==null)

         {
         	customResponse.setStatus("Failure");
         	customResponse.setStatusCode(404);
         	customResponse.setMessage("AndroidVersionForceUpdate Not Updated");
         	customResponse.setResults(null);
       	  return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.BAD_REQUEST);  
       	        	  
         }
    	 AndroidVersionForceUpdate result = androidVersionForceUpdateService.save(androidVersionForceUpdate);
         	customResponse.setStatus("Success");
         	customResponse.setStatusCode(200);
         	customResponse.setMessage("AndroidVersionForceUpdate Updated");
         	customResponse.setResults(result);
    	  
    	  return customResponse;
         }
         
      

    /**
     * {@code GET  /android-version-force-updates} : get all the androidVersionForceUpdates.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of androidVersionForceUpdates in body.
     */
    @GetMapping("/androidVersionForceUpdates")
    //@Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object getAllAndroidVersionForceUpdates() {
        log.debug("REST request to get all AndroidVersionForceUpdates");
        
        List<AndroidVersionForceUpdate> androidVersionForceUpdate= androidVersionForceUpdateService.findAll();
        
        if(androidVersionForceUpdate.isEmpty())
        {
        	customResponse.setStatus("Failure");
        	customResponse.setStatusCode(404);
        	customResponse.setMessage("androidVersionForceUpdateCollection Not Found");
        	customResponse.setResults(null);
        	return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);  
      	        	  
        }
        customResponse.setStatus("Success");
        customResponse.setStatusCode(200);
        customResponse.setMessage("androidVersionForceUpdateCollection Found");
        customResponse.setResults(androidVersionForceUpdate);
   	  
        return customResponse;
       }
        
        
        
    

    /**
     * {@code GET  /android-version-force-updates/:id} : get the "id" androidVersionForceUpdate.
     *
     * @param id the id of the androidVersionForceUpdate to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the androidVersionForceUpdate, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/androidVersionForceUpdates/{id}")
    //@Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object getAndroidVersionForceUpdate(@PathVariable String id) {
        log.debug("REST request to get AndroidVersionForceUpdate : {}", id);
        List<AndroidVersionForceUpdate> androidVersionForceUpdate = androidVersionForceUpdateService.findById(id);
        
        if(androidVersionForceUpdate.isEmpty())
        {
        	customResponse.setStatus("Failure");
        	customResponse.setStatusCode(404);
        	customResponse.setMessage("androidVersionForceUpdateCollection Not Found ");
        	customResponse.setResults(null);
      	  return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);  
      	        	  
        }
    
        customResponse.setStatus("Success");
        customResponse.setStatusCode(200);
        customResponse.setMessage("androidVersionForceUpdateCollection Found");
        customResponse.setResults(androidVersionForceUpdate);
   	  
        return customResponse;
        }
       

    /**
     * {@code DELETE  /android-version-force-updates/:id} : delete the "id" androidVersionForceUpdate.
     *
     * @param id the id of the androidVersionForceUpdate to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/androidVersionForceUpdates/{id}")
   // @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object deleteAndroidVersionForceUpdate(@PathVariable String id) {
        log.debug("REST request to delete AndroidVersionForceUpdate : {}", id);
        
        List<AndroidVersionForceUpdate> androidVersionForceUpdate = androidVersionForceUpdateService.findById(id);
        if(androidVersionForceUpdate.isEmpty())
    	{
        	customResponse.setStatus("Failure");
        	customResponse.setMessage("androidVersionForceUpdateCollection  not found");
   		 	return new ResponseEntity<>(customResponse,HttpStatus.NOT_FOUND);
    	}
    	
    	
    	try
    	{
            androidVersionForceUpdateService.delete(id);
	
    	}    
    	catch (Exception e)
    	{
    		customResponse.setStatus("Failure");
    		customResponse.setMessage("androidVersionForceUpdateCollection  not deleted");
      		 return new ResponseEntity<>(customResponse,HttpStatus.BAD_REQUEST);
		}
    	
    	customResponse.setStatus("Success");
    	customResponse.setMessage("androidVersionForceUpdateCollection record deleted");
        return customResponse;
    		 
    	}
  }
    
    
    
    
    
    
    

