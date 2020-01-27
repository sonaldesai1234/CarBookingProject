package com.mycipl.web.rest;


import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hazelcast.com.eclipsesource.json.JsonArray;
import com.hazelcast.com.eclipsesource.json.JsonObject;
import com.mycipl.domain.CustomResponse;
import com.mycipl.domain.DealerCollection;
import com.mycipl.security.AuthoritiesConstants;
import com.mycipl.service.DealerCollectionService;
import com.mycipl.web.rest.errors.BadRequestAlertException;



/**
 * REST controller for managing {@link project1.domain.DealerCollection}.
 */
@RestController
@RequestMapping("/api")
public class DealerCollectionResource {

    private final Logger log = LoggerFactory.getLogger(DealerCollectionResource.class);

    private static final String ENTITY_NAME = "dealerCollection";

    
    private final DealerCollectionService dealerCollectionService;
    CustomResponse customResponse=new CustomResponse();
     

    public DealerCollectionResource(DealerCollectionService dealerCollectionService) {
        this.dealerCollectionService = dealerCollectionService;
     
        
    }

    /**
     * {@code POST  /dealer-collections} : Create a new dealerCollection.
     *
     * @param dealerCollection the dealerCollection to create.1111
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new dealerCollection, or with status {@code 400 (Bad Request)} if the dealerCollection has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
   
    @PostMapping("/dealer")
   // @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object createDealerCollection(@RequestBody DealerCollection dealerCollection) throws URISyntaxException {
        log.debug("REST request to save DealerCollection : {}", dealerCollection);
        
        if (dealerCollection.getId() != null) {
            throw new BadRequestAlertException("A new dealerCollection cannot already have an ID", ENTITY_NAME, "idexists");
        }
        
      	 if(dealerCollection.getCityName()==null||dealerCollection.getLocation()==null||dealerCollection.getAddress()==null||dealerCollection.getName()==null){
     	   customResponse.setStatus("Failure");
     	   customResponse.setStatusCode(404);
     	   customResponse.setMessage("Dealer not Created");
      	   customResponse.setResults(null);
     	   return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.BAD_REQUEST);  
      	  
        }
      	  DealerCollection result = dealerCollectionService.save(dealerCollection);
             	 
          customResponse.setStatus("Success");
          customResponse.setStatusCode(200);;
          customResponse.setMessage("Dealer Created");
          customResponse.setResults(result);
    	  
    	  return customResponse;
          
       
       }
       
                
      /*  return ResponseEntity.created(new URI("/api/dealer-collections/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /dealer-collections} : Updates an existing dealerCollection.
     *
     * @param dealerCollection the dealerCollection to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dealerCollection,
     * or with status {@code 400 (Bad Request)} if the dealerCollection is not valid,
     * or with status {@code 500 (Internal Server Error)} if the dealerCollection couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/dealer")
  //  @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object updateDealerCollection(@RequestBody DealerCollection dealerCollection) throws URISyntaxException {
        log.debug("REST request to update DealerCollection : {}", dealerCollection);
        if (dealerCollection.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        
        if(dealerCollection.getCityName()==null||dealerCollection.getLocation()==null||dealerCollection.getAddress()==null||dealerCollection.getName()==null)
        {
       	   customResponse.setStatus("Failure");
     	   customResponse.setStatusCode(404);
     	   customResponse.setMessage("Dealer not Updated");
      	   customResponse.setResults(null);
      	   return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);  
      	      	  
        }
      		
          
      	  DealerCollection result = dealerCollectionService.save(dealerCollection);
          customResponse.setStatus("Success");
          customResponse.setStatusCode(200);;
          customResponse.setMessage("Dealer Update");
          customResponse.setResults(result);
    	  
    	  return customResponse;
          
       
       }
       
        
        
        
      /*  return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, dealerCollection.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /dealer-collections} : get all the dealerCollections.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of dealerCollections in body.
     */
    @SuppressWarnings("rawtypes")
	@GetMapping("/dealer")
    //@Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object getAllDealerCollections() {
        log.debug("REST request to get all DealerCollections");
        List<DealerCollection> result= dealerCollectionService.findAll();
		
     	 if(result==null)
       {
    	   customResponse.setStatus("Failure");
    	   customResponse.setStatusCode(404);
    	   customResponse.setMessage("Dealer not Found");
     	   customResponse.setResults(null);
    	  return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.BAD_REQUEST);  
     	  
       }
     		
            	 
         customResponse.setStatus("Success");
         customResponse.setStatusCode(200);;
         customResponse.setMessage("Dealer Found");
         customResponse.setResults(result);
   	     return customResponse;
         
      
      }
   
    /*
        return  dealerCollectionService.findAll();
        
         
    }

    /**
     * {@code GET  /dealer-collections/:id} : get the "id" dealerCollection.
     *
     * @param id the id of the dealerCollection to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the dealerCollection, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/dealer/{id}")
   // @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object getDealerCollection(@PathVariable String id) {
        log.debug("REST request to get DealerCollection : {}", id);
        
     
        Optional<DealerCollection> dealerCollection = dealerCollectionService.findOne(id);	
        
   		
     	 if(dealerCollection==null)
       {
    	   customResponse.setStatus("Failure");
    	   customResponse.setStatusCode(404);
    	   customResponse.setMessage("Dealer not found");
     	  
    	   customResponse.setResults(null);
     	  return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);  
     	  }
     	  
         customResponse.setStatus("Success");
         customResponse.setStatusCode(200);;
         customResponse.setMessage("Dealer found");
         customResponse.setResults(dealerCollection);
   	  
   	     return customResponse;
         
      
      }
      
       /* 
        return ResponseUtil.wrapOrNotFound(dealerCollection);
    }

    /**
     * {@code DELETE  /dealer-collections/:id} : delete the "id" dealerCollection.
     *
     * @param id the id of the dealerCollection to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @SuppressWarnings("unused")
	@DeleteMapping("/dealer/{dealerCode}")
   // @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object deleteDealerCollection(@PathVariable String dealerCode) {
        log.debug("REST request to delete DealerCollection : {}", dealerCode);
       
   
        DealerCollection dealerCollection =dealerCollectionService.findOneByDealerCode(dealerCode);
        String id= dealerCollection.getId();
    	if(dealerCollection==null)
    	{
    	 customResponse.setStatus("Failure");
   		 customResponse.setMessage("Dealer Not Found");
   		 return new ResponseEntity<>(customResponse,HttpStatus.NOT_FOUND);
    	}
    	
    	try
    	{
    	dealerCollectionService.delete(id);
    	}
    	catch(Exception e)
    	{
    
    		customResponse.setStatus("Failure");
     		 customResponse.setMessage("Dealer Not deleted");
     		 return new ResponseEntity<>(customResponse,HttpStatus.BAD_REQUEST);
		}
    	
    		customResponse.setStatus("Success");
    		customResponse.setMessage("Dealer Deleted");
    		return customResponse;
    	
}
    
        //return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id)).build();
 
    @GetMapping("/dealercode/{dealerCode}")
   // @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object getDealerCodeWiseLocation(@PathVariable String dealerCode)
    {
    	log.debug("get request to get all DealerCollection");
    	if(dealerCode==null||"".equalsIgnoreCase(dealerCode))
    	{
            throw new BadRequestAlertException("Invalid Value", ENTITY_NAME, "dealerCode cant be null");
            
    	}
       List<DealerCollection> dealerCollection=dealerCollectionService.findByDealerCode(dealerCode);
   	
   	  if(dealerCollection.isEmpty())
      {
   		  customResponse.setStatus("Failure");
   		  customResponse.setStatusCode(404);
   		  customResponse.setMessage("Dealer not found");
    	  
   		  customResponse.setResults(null);
    	  return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);  
    	  
      }
       customResponse.setStatus("Success");
       customResponse.setStatusCode(200);
       customResponse.setMessage("Dealer found");
       customResponse.setResults(dealerCollection);
 	  
 	  return customResponse;
       
    }
  
    @GetMapping("/dealerCode")
   // @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object getDealerCode(@RequestBody HashMap<String,ArrayList<String>> dealerCode)
    {
    	log.debug("get request to get all DealerCollection by dealerCode Wise ");
    	List<DealerCollection> dealerCollection=new ArrayList<>();
    	
    	if(dealerCode==null)
    	{
            throw new BadRequestAlertException("Invalid Value", ENTITY_NAME, "dealerCode cant be null");
    	}
    	ArrayList<String> List= dealerCode.get("dealerCode");
    	
    	if(List !=null && !List.isEmpty()) {
	    	for (String str : List) {
	    		List<DealerCollection> dealerCollectionDB=dealerCollectionService.findByDealerCode(str);
	    		if(dealerCollectionDB.isEmpty())
			      {
			   		  customResponse.setStatus("Failure");
			   		  customResponse.setStatusCode(404);
			   		  customResponse.setMessage(str +" Dealer Code not found");
			    	  
			   		  customResponse.setResults(null);
			    	  return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);  
			    	  
			      }
	        	dealerCollection.addAll(dealerCollectionDB);
			}
    	}
     
    	if(dealerCollection.isEmpty())
		      {
		   		  customResponse.setStatus("Failure");
		   		  customResponse.setStatusCode(404);
		   		  customResponse.setMessage("DealerCode not found");
		    	  
		   		  customResponse.setResults(null);
		    	  return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);  
		    	  
		      }
	       customResponse.setStatus("Success");
	       customResponse.setStatusCode(200);
	       customResponse.setMessage("Dealer found");
	       customResponse.setResults(dealerCollection);
	 	  
	 	  return customResponse;
    }

    @GetMapping("/dealerCity/{cityName}")
   // @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object getDealercity(@PathVariable String cityName)
    {
    	log.debug("get request to get all DealerCollection");
    	
    	if(cityName==null||"".equalsIgnoreCase(cityName))
    	{
            throw new BadRequestAlertException("Invalid Value", ENTITY_NAME, "cityName cant be null");
            
    	}
       List<DealerCollection> dealerCollection=dealerCollectionService.findByCityName(cityName);
   	
   	  if(dealerCollection.isEmpty())
      {
   		  customResponse.setStatus("Failure");
   		  customResponse.setStatusCode(404);
   		  customResponse.setMessage("city Name not found");
    	  
   		  customResponse.setResults(null);
    	  return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);  
      }
   	 
       customResponse.setStatus("Success");
       customResponse.setStatusCode(200);
       customResponse.setMessage("city Name found");
       customResponse.setResults(dealerCollection);
 	  
 	  return customResponse;
    
    }
    
    
   
    
    
    
}
