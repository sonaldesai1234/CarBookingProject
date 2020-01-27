package com.mycipl.web.rest;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.mycipl.domain.CityCollection;
import com.mycipl.domain.CustomResponse;
import com.mycipl.security.AuthoritiesConstants;
import com.mycipl.service.CityCollectionService;
import com.mycipl.web.rest.errors.BadRequestAlertException;

/**
 * REST controller for managing {@link project1.domain.CityCollection}.
 */
@RestController
@RequestMapping("/api")
public class CityCollectionResource {

    private final Logger log = LoggerFactory.getLogger(CityCollectionResource.class);

    private static final String ENTITY_NAME = "cityCollection";


    private final CityCollectionService cityCollectionService;
    CustomResponse customResponse=new CustomResponse();

    public CityCollectionResource(CityCollectionService cityCollectionService) {
        this.cityCollectionService = cityCollectionService;
    }

    /**
     * {@code POST  /city-collections} : Create a new cityCollection.
     *
     * @param cityCollection the cityCollection to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cityCollection, or with status {@code 400 (Bad Request)} if the cityCollection has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/city")
   // @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object createCityCollection(@RequestBody CityCollection cityCollection) throws URISyntaxException {
        
    	log.debug("REST request to save CityCollection : {}", cityCollection);
      
        if (cityCollection.getId() != null) {
            throw new BadRequestAlertException("A new cityCollection cannot already have an ID", ENTITY_NAME, "idexists");
        }
       
       

        if(cityCollection.getCityName()==null)
        {
        	customResponse.setStatus("Failure");
        	customResponse.setStatusCode(404);
        	customResponse.setMessage("City Not Created");
        	customResponse.setResults(null);
      	  return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.BAD_REQUEST);  
      	        	  
        }
        
        CityCollection result = cityCollectionService.save(cityCollection);
        customResponse.setStatus("Success");
        customResponse.setStatusCode(200);
        customResponse.setMessage("City Created");
        customResponse.setResults(result);
   	  
   	   return customResponse;
        }
        
    
    /**
     * {@code PUT  /city-collections} : Updates an existing cityCollection.
     *
     * @param cityCollection the cityCollection to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cityCollection,
     * or with status {@code 400 (Bad Request)} if the cityCollection is not valid,
     * or with status {@code 500 (Internal Server Error)} if the cityCollection couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/city")
    //@Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object updateCityCollection(@RequestBody CityCollection cityCollection) throws URISyntaxException {
        log.debug("REST request to update CityCollection : {}", cityCollection);
        if (cityCollection.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        String id=cityCollection.getId();
        CityCollection cityCollectionObj=cityCollectionService.findOneById(id);
        cityCollection.setId(id);
       

        if(cityCollectionObj==null)

        {
        	customResponse.setStatus("Failure");
        	customResponse.setStatusCode(404);
        	customResponse.setMessage("City Not Updated");
        	customResponse.setResults(null);
      	  return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.BAD_REQUEST);  
      	        	  
        }
        	CityCollection result = cityCollectionService.save(cityCollection);
        	customResponse.setStatus("Success");
        	customResponse.setStatusCode(200);
        	customResponse.setMessage("City Updated");
        	customResponse.setResults(result);
   	  
   	  return customResponse;
        }
        
     

    /**
     * {@code GET  /city-collections} : get all the cityCollections.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cityCollections in body.
     */
    @GetMapping("/city")

   // @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})

    public Object getAllCityCollections() {
        log.debug("REST request to get all CityCollections");
        
        List<CityCollection> cityCollections=cityCollectionService.findAll();
        
        if(cityCollections==null)
        {
        	customResponse.setStatus("Failure");
        	customResponse.setStatusCode(404);
        	customResponse.setMessage("City Not Found");
        	customResponse.setResults(null);
      	  return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.BAD_REQUEST);  
      	        	  
        }
        	customResponse.setStatus("Success");
        	customResponse.setStatusCode(200);
        	customResponse.setMessage("City Found");
        	customResponse.setResults(cityCollections);
   	  
   	  return customResponse;
        }
        
      
    

    /**
     * {@code GET  /city-collections/:id} : get the "id" cityCollection.
     *
     * @param id the id of the cityCollection to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cityCollection, or with status {@code 404 (Not Found)}.
     */
    
    
    @GetMapping("/city/{id}")
  //  @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object getCityCollection(@PathVariable String id) {
        log.debug("REST request to get CityCollection : {}", id);

       

      //  Optional<CityCollection> cityCollection = cityCollectionService.findOne(id);

        CityCollection cityCollectionObj=cityCollectionService.findOneById(id);

        
        if(cityCollectionObj==null)
        {
        	customResponse.setStatus("Failure");
        	customResponse.setStatusCode(404);
        	customResponse.setMessage("City Not Found");
        	customResponse.setResults(null);
      	  return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.BAD_REQUEST);  
      	        	  
        }else
        {
       		customResponse.setStatus("Success");
       		customResponse.setStatusCode(200);
       		customResponse.setMessage("City Found");
       		customResponse.setResults(cityCollectionObj);
   	  
   	  return customResponse;
        }
    
    }
    
    @GetMapping("/cityByCity/{cityName}")
  //  @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object getCity(@PathVariable String cityName) {
        log.debug("REST request to get CityCollection : {}", cityName);
        CityCollection cityCollection = cityCollectionService.findOneByCityName(cityName);
        
        if(cityCollection==null)
        {
        	customResponse.setStatus("Failure");
        	customResponse.setStatusCode(404);
        	customResponse.setMessage("City Not Found");
        	customResponse.setResults(null);
      	  return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.BAD_REQUEST);  
      	        	  
        }
       		customResponse.setStatus("Success");
       		customResponse.setStatusCode(200);
       		customResponse.setMessage("City Found");
       		customResponse.setResults(cityCollection);
   	  
   	  return customResponse;
        }
   
    /**
     * {@code DELETE  /city-collections/:id} : delete the "id" cityCollection.
     *
     * @param id the id of the cityCollection to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/city/{id}")
  //  @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER,AuthoritiesConstants.MANAGER,AuthoritiesConstants.TEAMLEADER,AuthoritiesConstants.DSE})
    public Object deleteCityCollection(@PathVariable String id) {
        log.debug("REST request to delete CityCollection : {}", id);
          

        CityCollection cityCollectionObj=cityCollectionService.findOneById(id);


    


    	if(cityCollectionObj == null)

    		
    	{
    		 customResponse.setStatus("Failure");
       		 customResponse.setMessage("City Not found");
       		 return new ResponseEntity<>(customResponse,HttpStatus.NOT_FOUND);
    		
    	}
    	try
    	{
    		cityCollectionService.delete(id);
    	}
    	catch(Exception e)
    	{
    		
    		 customResponse.setStatus("Failure");
    		 customResponse.setMessage("City Not deleted");
    		 return new ResponseEntity<>(customResponse,HttpStatus.BAD_REQUEST);
    	}
    	
    	
    		customResponse.setStatus("Success");
    		customResponse.setMessage("City deleted");
    		customResponse.setResults(null);
    		return customResponse;
    	}
       
      
}
