package com.mycipl.web.rest;
import java.net.URISyntaxException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.mycipl.domain.CarBookingsCollection;
import com.mycipl.domain.CustomResponse;
import com.mycipl.domain.DealerCollection;
import com.mycipl.domain.User;
import com.mycipl.domain.UserProfile;
import com.mycipl.repository.UserProfileRepository;
import com.mycipl.repository.UserRepository;
import com.mycipl.security.AuthoritiesConstants;
import com.mycipl.service.UserProfileService;
import com.mycipl.service.UserService;
import com.mycipl.service.dto.UserProfileDTO;
import com.mycipl.service.impl.UserProfileServiceImpl;
import com.mycipl.web.rest.errors.BadRequestAlertException;
import com.mycipl.web.rest.util.HeaderUtil;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing UserProfile.
 */
@RestController
@RequestMapping("/api")
public class UserProfileResource {

    private final Logger log = LoggerFactory.getLogger(UserProfileResource.class);

    private static final String ENTITY_NAME = "userProfile";

    private final UserProfileService userProfileService;
    
    @Autowired
    UserProfileRepository userProfileRepository;
    
    @Autowired
    UserProfileServiceImpl userProfileServiceImpl;
    
    @Autowired
	UserRepository userRepository;
    
    @Autowired
    UserService userService;
    
	CustomResponse customResponse=new CustomResponse();


    public UserProfileResource(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    /**
     * POST  /user : Create a new userProfile.
     *
     * @param userProfile the userProfile to create
     * @return the ResponseEntity with status 201 (Created) and with body the new userProfile, or with status 400 (Bad Request) if the userProfile has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/user")
    public Object  createUserProfile(@RequestBody UserProfileDTO userProfileDTO) throws URISyntaxException {
        log.debug("REST request to save UserProfile : {}", userProfileDTO);
        if (userProfileDTO.getId() != null) {
            throw new BadRequestAlertException("A new userProfile cannot already have an ID", ENTITY_NAME, "idexists");
        }
          
        UserProfile userProfile= userProfileServiceImpl.createUser(userProfileDTO);

        if(userProfile!=null)
		{
		customResponse.setStatus("Success");
		customResponse.setStatusCode(200);
		customResponse.setMessage("user Register");
		customResponse.setResults(userProfile);
		 
		}
		return customResponse;
   
    }


    /**
     * PUT  /user : Updates an existing userProfile.
     *
     * @param userProfile the userProfile to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated userProfile,
     * or with status 400 (Bad Request) if the userProfile is not valid,
     * or with status 500 (Internal Server Error) if the userProfile couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/user")
    public Object updateUserProfile(@RequestBody UserProfile userProfile) throws URISyntaxException {
        log.debug("REST request to update UserProfile : {}", userProfile);
        
        if (userProfile.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        
        String id=userProfile.getId();
        UserProfile userProfileObj=userProfileRepository.findOneById(id);
        userProfile.setId(userProfileObj.getId());
        
        
		
		
       
        
        UserProfile userProfile1= userProfileServiceImpl.updateUser(userProfile);

      //  UserProfile result = userProfileService.save(userProfile);
       
        if(userProfile!=null)
		{
		customResponse.setStatus("Success");
		customResponse.setStatusCode(200);
		customResponse.setMessage("user updated");
		customResponse.setResults(userProfile1);
		 
		}
		return customResponse;
    }
   
    	
    
  /*  

    /**
     * GET  /user : get all the userProfiles.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of userProfiles in body
     */

 
    @GetMapping("/user/{role}/{dealerCode}/{teamLeader}")
    public Object getUserDetailsList(@PathVariable String role,@PathVariable String dealerCode,@PathVariable String teamLeader) {

    	List<UserProfile> userProfile = userProfileService.findByRoleAndDealerCodeAndTeamLeader(role,dealerCode,teamLeader);
        
        if(userProfile.isEmpty())
        {
     	   customResponse.setStatus("Failure");
     	   customResponse.setStatusCode(404);
     	   customResponse.setMessage("user not found");
        	  
     	   customResponse.setResults(null);
        	  return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);  
 		
        }
       
        customResponse.setStatus("Success");
        customResponse.setStatusCode(200);
        customResponse.setMessage("user found");
        customResponse.setResults(userProfile);
  	  
  	  return customResponse;
		
    }
    
    @GetMapping("/userByRole/{dealerCode}/{role}")
    public Object getUser(@PathVariable String dealerCode,@PathVariable String role) 
    {

    	List<UserProfile> userProfile = userProfileService.findByDealerCodeAndRole(dealerCode,role);
        
        if(userProfile.isEmpty())
        {
     	   customResponse.setStatus("Failure");
     	   customResponse.setStatusCode(404);
     	   customResponse.setMessage("user not found");
        	  
     	   customResponse.setResults(null);
        	  return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);  
 		
        }
       
        customResponse.setStatus("Success");
        customResponse.setStatusCode(200);
        customResponse.setMessage("user found");
        customResponse.setResults(userProfile);
  	  
  	  return customResponse;
		
    }
    @GetMapping("/userByDealer/{dealerCode}/{teamLeader}")
    public Object getUserDetails(@PathVariable String dealerCode,@PathVariable String teamLeader) {

    	List<UserProfile> userProfile = userProfileService.findByDealerCodeAndTeamLeader(dealerCode,teamLeader);
        
        if(userProfile.isEmpty())
        {
     	   customResponse.setStatus("Failure");
     	   customResponse.setStatusCode(404);
     	   customResponse.setMessage("user not found");
        	  
     	   customResponse.setResults(null);
        	  return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);  
 		
        }
       
        customResponse.setStatus("Success");
        customResponse.setStatusCode(200);
        customResponse.setMessage("user found");
        customResponse.setResults(userProfile);
  	  
  	  return customResponse;
		
    }
    @GetMapping("/ciplUser/{dseLoginId}")
    public Object getUserbyLoginId(@PathVariable String dseLoginId) {

    UserProfile userProfile = userProfileService.findByDseLoginId(dseLoginId);
      
        if(userProfile==null)
        {
     	   customResponse.setStatus("Failure");
     	   customResponse.setStatusCode(404);
     	   customResponse.setMessage("user not found");
        	  
     	   customResponse.setResults(null);
        	return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);  
 		
        }
       
        customResponse.setStatus("Success");
        customResponse.setStatusCode(200);
        customResponse.setMessage("user found");
        customResponse.setResults(userProfile);
  	  
  	  return customResponse;
		
    }


    /**
     * DELETE  /user/:id : delete the "id" userProfile.
     *
     * @param id the id of the userProfile to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    //UserProfile userProfile=new UserProfile();
    
    

    @GetMapping("/user/{dealerCode}")
    public Object getUserDetailsByDealerCode(@PathVariable String dealerCode) {
    	log.debug("REST request for get all user data by delerCode wise", dealerCode );
    	   
    	List<UserProfile> userProfile = userProfileService.findByDealerCode(dealerCode);
    
        if(userProfile.isEmpty())
        {
     	   customResponse.setStatus("Failure");
     	   customResponse.setStatusCode(404);
     	   customResponse.setMessage("user not found");
        	  
     	   customResponse.setResults(null);
        	  return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);  
 		
        }
       
        customResponse.setStatus("Success");
        customResponse.setStatusCode(200);
        customResponse.setMessage("user found");
        customResponse.setResults(userProfile);
  	  
  	  return customResponse;
		
    }
    
    @GetMapping("/users")
    public Object getAllUsersDetails() {
    	log.debug("REST request for get all user data " );
    	
    	List<UserProfile> userProfile = userProfileService.findAll();
        
        if(userProfile.isEmpty() || userProfile.isEmpty())
        {
     	   customResponse.setStatus("Failure");
     	   customResponse.setStatusCode(404);
     	   customResponse.setMessage("user not found");
        	  
     	   customResponse.setResults(null);
        	  return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);  
 		
        }
       
        customResponse.setStatus("Success");
        customResponse.setStatusCode(200);
        customResponse.setMessage("user found");
        customResponse.setResults(userProfile);
  	  
  	  return customResponse;
		
    }
    
    @GetMapping("/users/{teamLeader}")
    public Object getUserDetailsByTeamLeader(@PathVariable String teamLeader) {
    	log.debug("REST request for get all users data by teamLeaderWise" );
    	
    	List<UserProfile> userProfile = userProfileService.findByTeamLeader(teamLeader);
        
        if(userProfile.isEmpty() || userProfile.isEmpty())
        {
     	   customResponse.setStatus("Failure");
     	   customResponse.setStatusCode(404);
     	   customResponse.setMessage("user not found");
        	  
     	   customResponse.setResults(null);
        	  return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);  
        }
       
        customResponse.setStatus("Success");
        customResponse.setStatusCode(200);
        customResponse.setMessage("user found");
        customResponse.setResults(userProfile);
  	  
  	  return customResponse;
		
    }
  
    @GetMapping("/findTeamLeader/{role}/{dealerCode}")
    public Object getUserWith(@PathVariable String role, @PathVariable String dealerCode ) {
    	log.debug("REST request for get all users data by dseLoginId n dealerCode Wise" );
    	List<String> teamLeader =new ArrayList<String>();
    	
    	List<UserProfile> userProfile = userProfileService.findByRoleAndDealerCode(role,dealerCode);
   
    
    
    for (UserProfile userProfile2 : userProfile) {
    	
    	teamLeader.add(userProfile2.getTeamLeader());
    	
		
	}
      
        if(teamLeader.isEmpty())
        {
     	   customResponse.setStatus("Failure");
     	   customResponse.setStatusCode(404);
     	   customResponse.setMessage("user not found");
        	  
     	   customResponse.setResults(null);
        	return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);  
 		
        }
       
        customResponse.setStatus("Success");
        customResponse.setStatusCode(200);
        customResponse.setMessage("user found");
        customResponse.setResults(teamLeader);
  	  
  	  return customResponse;
		
    }
    
    
    @GetMapping("/user/{dseLoginId}/{dealerCode}")
    public Object getUserbyLoginIdAndDealerCode(@PathVariable String dseLoginId, @PathVariable String dealerCode ) {
    	log.debug("REST request for get all users data by dseLoginId n dealerCode Wise" );
    	
    	List<UserProfile> userProfile = userProfileRepository.findByDealerCodeAndDseLoginId(dealerCode,dseLoginId);
        System.out.println("userProfile ===="+userProfile.toString());
      
        if(userProfile==null || userProfile.isEmpty())
        {
     	   customResponse.setStatus("Failure");
     	   customResponse.setStatusCode(404);
     	   customResponse.setMessage("user not found");
        	  
     	   customResponse.setResults(null);
        	return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);  
 		
        }
       
        customResponse.setStatus("Success");
        customResponse.setStatusCode(200);
        customResponse.setMessage("user found");
        customResponse.setResults(userProfile);
  	  
  	  return customResponse;
		
    }
    @SuppressWarnings("unused")
	@DeleteMapping("/user/{dseLoginId}")
    public Object deleteUserProfile(@PathVariable String dseLoginId) 
    {
    	
    	UserProfile userProfile =userProfileService.findByDseLoginId(dseLoginId);
        Optional<User> user=userRepository.findOneByDseLoginId(dseLoginId);
        
    	String id= userProfile.getId();
    	
    	if(userProfile==null)
    	{
    	 customResponse.setStatus("Failure");
    	 customResponse.setMessage("user record not found");
   		 return new ResponseEntity<>(customResponse,HttpStatus.NOT_FOUND);
    	}
    	
    	try
    	{
    		 userProfileService.delete(id);	
    		 userRepository.deleteById(user.get().getId());
    	}   
    	
    	catch (Exception e)
    	{
    		customResponse.setStatus("Failure");
    		customResponse.setMessage("user record  record not deleted");
      		 return new ResponseEntity<>(customResponse,HttpStatus.BAD_REQUEST);
		}
    	customResponse.setStatus("Success");
    	customResponse.setMessage("user record record deleted");
    	customResponse.setResults(null);
        return customResponse;
    		 
    	}
    
    	
}
