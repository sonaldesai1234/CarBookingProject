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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycipl.domain.CustomResponse;
import com.mycipl.domain.DemoCarModelCollection;
import com.mycipl.domain.OtpCollection;
import com.mycipl.security.AuthoritiesConstants;
import com.mycipl.service.DemoCarModelCollectionService;
import com.mycipl.web.rest.errors.BadRequestAlertException;

/**
 * REST controller for managing {@link project1.domain.DemoCarModelCollection}.
 */
@RestController
@RequestMapping("/api")
public class DemoCarModelCollectionResource {

    private final Logger log = LoggerFactory.getLogger(DemoCarModelCollectionResource.class);

    private static final String ENTITY_NAME = "demoCarModelCollection";


    private final DemoCarModelCollectionService demoCarModelCollectionService;
    CustomResponse CustomResponse=new CustomResponse();

    public DemoCarModelCollectionResource(DemoCarModelCollectionService demoCarModelCollectionService) {
        this.demoCarModelCollectionService = demoCarModelCollectionService;
    }

    /**
     * {@code POST  /demo-car-model-collections} : Create a new demoCarModelCollection.
     *
     * @param demoCarModelCollection the demoCarModelCollection to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new demoCarModelCollection, or with status {@code 400 (Bad Request)} if the demoCarModelCollection has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @SuppressWarnings("unused")
	@PostMapping("/carModel")
   // @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object createDemoCarModelCollection(@RequestBody DemoCarModelCollection demoCarModelCollection) throws URISyntaxException {
        log.debug("REST request to save DemoCarModelCollection : {}", demoCarModelCollection);
        if (demoCarModelCollection.getId() != null) {
            throw new BadRequestAlertException("A new demoCarModelCollection cannot already have an ID", ENTITY_NAME, "idexists");
        }
        
        DemoCarModelCollection result = demoCarModelCollectionService.save(demoCarModelCollection);

        
        if(demoCarModelCollection==null)
        {
     	   CustomResponse.setStatus("Failure");
     	   CustomResponse.setStatusCode(404);
     	   CustomResponse.setMessage("Car Not Created");
      	  
     	   CustomResponse.setResults(null);
      	  return new ResponseEntity<CustomResponse>(CustomResponse, HttpStatus.NOT_FOUND);  
      	  
      	  
        }
        
          CustomResponse.setStatus("Success");
          CustomResponse.setStatusCode(200);
          CustomResponse.setMessage("Car created");
          CustomResponse.setResults(result);
    	  return CustomResponse;
          
       
       }
    
   
    /**
     * {@code PUT  /demo-car-model-collections} : Updates an existing demoCarModelCollection.
     *
     * @param demoCarModelCollection the demoCarModelCollection to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated demoCarModelCollection,
     * or with status {@code 400 (Bad Request)} if the demoCarModelCollection is not valid,
     * or with status {@code 500 (Internal Server Error)} if the demoCarModelCollection couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
   @SuppressWarnings("unused")
   @PutMapping("/carModel")
   //@Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object updateDemoCarModelCollection(@RequestBody DemoCarModelCollection demoCarModelCollection) throws URISyntaxException {
        log.debug("REST request to update DemoCarModelCollection : {}", demoCarModelCollection);
        if (demoCarModelCollection.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        
        
        if(demoCarModelCollection==null)
        {
     	   CustomResponse.setStatus("Failure");
     	   CustomResponse.setStatusCode(404);
     	   CustomResponse.setMessage("DemoCarModel Collection not found");
      	  
     	   CustomResponse.setResults(null);
      	  return new ResponseEntity<CustomResponse>(CustomResponse, HttpStatus.NOT_FOUND);  
      	  
      	  
        }
        DemoCarModelCollection result = demoCarModelCollectionService.save(demoCarModelCollection);

      	 
          CustomResponse.setStatus("Success");
          CustomResponse.setStatusCode(200);
          CustomResponse.setMessage("DemoCarModel Collection  found");
          CustomResponse.setResults(result);
    	  
    	  return CustomResponse;
    	  
   }
   
  
       
 
    	
  

    /**
     * {@code GET  /demo-car-model-collections} : get all the demoCarModelCollections.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of demoCarModelCollections in body.
     */
    @GetMapping("/carModel")
   // @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object getAllDemoCarModelCollections() {
        log.debug("REST request to get all DemoCarModelCollections");
        List<DemoCarModelCollection> result=demoCarModelCollectionService.findAll();
        if(result.isEmpty())
        {
     	   CustomResponse.setStatus("Failure");
     	   CustomResponse.setStatusCode(404);
     	   CustomResponse.setMessage("DemoCarModel Collection not found");
      	  
     	   CustomResponse.setResults(null);
      	  return new ResponseEntity<CustomResponse>(CustomResponse, HttpStatus.NOT_FOUND);  
      	  
      	  
        }
      	 
          CustomResponse.setStatus("Success");
          CustomResponse.setStatusCode(200);
          CustomResponse.setMessage("DemoCarModel Collection  found");
          CustomResponse.setResults(result);
    	  
    	  return CustomResponse;
          
       
       }
    /*
        return demoCarModelCollectionService.findAll();
    }

    /**
     * {@code GET  /demo-car-model-collections/:id} : get the "id" demoCarModelCollection.
     *
     * @param id the id of the demoCarModelCollection to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the demoCarModelCollection, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/carModel/{id}")
  //  @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object getDemoCarModelCollection(@PathVariable String id) {
        log.debug("REST request to get DemoCarModelCollection : {}", id);
        Optional<DemoCarModelCollection> demoCarModelCollection = demoCarModelCollectionService.findOne(id);
        if(demoCarModelCollection==null)
        {
     	   CustomResponse.setStatus("Failure");
     	   CustomResponse.setStatusCode(404);
     	   CustomResponse.setMessage("DemoCarModel Collection not found");
      	  
     	   CustomResponse.setResults(null);
      	  return new ResponseEntity<CustomResponse>(CustomResponse, HttpStatus.NOT_FOUND);  
      	  
      	  
        }
      	 
          CustomResponse.setStatus("Success");
          CustomResponse.setStatusCode(200);
          CustomResponse.setMessage("DemoCarModel Collection  found");
          CustomResponse.setResults(demoCarModelCollection);
    	  
    	  return CustomResponse;
    }
        
	
    
    @GetMapping("/carDealer/{dealerCode}")
 //  @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object getDemoCarModel(@PathVariable String dealerCode)
    {
    	log.debug("get request to get all DemoCarModelCollection");
    	
    	
    	
    	if(dealerCode==null||"".equalsIgnoreCase(dealerCode))
    	{
            throw new BadRequestAlertException("Invalid Value", ENTITY_NAME, "DealerCode cant be null");
            
    	}
       List<DemoCarModelCollection> demoCarModelCollection=demoCarModelCollectionService.findByDealerCode(dealerCode);
   		

   	 if(demoCarModelCollection.isEmpty())
     {
  	   CustomResponse.setStatus("Failure");
  	   CustomResponse.setStatusCode(404);
  	   CustomResponse.setMessage("DemoCarModel Collection not found");
   	  
  	   CustomResponse.setResults(null);
   	  return new ResponseEntity<CustomResponse>(CustomResponse, HttpStatus.NOT_FOUND);  
   	  
   	  
     }
   	 
       CustomResponse.setStatus("Success");
       CustomResponse.setStatusCode(200);
       CustomResponse.setMessage("DemoCarModel Collection  found");
       CustomResponse.setResults(demoCarModelCollection);
 	  
 	  return CustomResponse;
       
    
    }
  

    /**
     * {@code DELETE  /demo-car-model-collections/:id} : delete the "id" demoCarModelCollection.
     *
     * @param id the id of the demoCarModelCollection to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/carModel/{id}")
    //@Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object deleteDemoCarModelCollection(@PathVariable String id) {
        log.debug("REST request to delete DemoCarModelCollection : {}", id);
        
        
        CustomResponse customResponse = new CustomResponse();
        
        List<DemoCarModelCollection> demoCarModelCollection =demoCarModelCollectionService.findOneById(id);
     
    	if(demoCarModelCollection.isEmpty())
    		
    	{
    		 customResponse.setStatus("Failure");
       		 customResponse.setMessage("Car Model Not found");
       		 return new ResponseEntity<>(customResponse,HttpStatus.NOT_FOUND);
    		
    	}
    	try
    	{
    		demoCarModelCollectionService.delete(id);
    	}
    	catch(Exception e)
    	{
    		
    		 customResponse.setStatus("Failure");
    		 customResponse.setMessage("Car Model not deleted");
    		 return new ResponseEntity<>(customResponse,HttpStatus.BAD_REQUEST);
    	}
    	 customResponse.setStatus("Success");
		 customResponse.setMessage("car Model deleted");
	     return customResponse;
    	}
       
    	
    	
    	
       
    }

        
    
    

