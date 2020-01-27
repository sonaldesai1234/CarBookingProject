package com.mycipl.web.rest;
import java.time.Instant;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mycipl.domain.AndroidVersionForceUpdate;
import com.mycipl.domain.CustomResponse;
import com.mycipl.domain.SocialClass;
import com.mycipl.domain.User;
import com.mycipl.domain.UserProfile;
import com.mycipl.repository.UserProfileRepository;
import com.mycipl.repository.UserRepository;
import com.mycipl.security.jwt.JWTFilter;
import com.mycipl.security.jwt.TokenProvider;
import com.mycipl.service.UserService;
import com.mycipl.service.dto.UserProfileDTO;
import com.mycipl.web.rest.vm.LoginVM;

/**
 * Controller to authenticate users.
 */
@RestController
@RequestMapping("/api")
public class UserJWTController {

	private final TokenProvider tokenProvider;

	private final AuthenticationManager authenticationManager;

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserProfileRepository userProfileRepository;

	@Autowired
	UserResource u;

	public UserJWTController(TokenProvider tokenProvider, AuthenticationManager authenticationManager) {
		this.tokenProvider = tokenProvider;
		this.authenticationManager = authenticationManager;
		

	}

	@PostMapping("/authenticate")
	public Object authorize(@Valid @RequestBody LoginVM loginVM) {

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				loginVM.getDseLoginId(), loginVM.getDsePassword());

		Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		boolean rememberMe = (loginVM.isRememberMe() == null) ? false : loginVM.isRememberMe();
		String jwt = tokenProvider.createToken(authentication, rememberMe);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

		UserProfile user = userProfileRepository.findByDseLoginId(loginVM.getDseLoginId());
		CustomResponse customResponse=new CustomResponse();

		
		if(user!=null)
		{
			
			SocialClass socialClass = new SocialClass();
			socialClass.setDseLoginId(user.getDseLoginId());
			socialClass.setDseMobileNumber(user.getDseMobileNumber());
			socialClass.setdLastLogin(user.getdLastLogin());
			socialClass.setEmail(user.getEmail());
			socialClass.setDealerName(user.getDealerName());
			socialClass.setDseName(user.getDseName());
			socialClass.setDealerLocation(user.getDealerLocation());
			socialClass.setTeamLeader(user.getTeamLeader());
			socialClass.setIsActive(user.getIsActive());
			socialClass.setIsActive(user.getIsActive());
			socialClass.setRole(user.getRole());
			socialClass.setDealerCode(user.getDealerCode());
			socialClass.setCreatedBy(user.getCreatedBy());
			socialClass.setCreatedOn(user.getCreatedOn());
			socialClass.setUpdatedBy(user.getUpdatedBy());
			socialClass.setUpdatedOn(user.getUpdatedOn());
			socialClass.setToken(jwt);
			customResponse.setStatus("Success");
			customResponse.setStatusCode(200);
			customResponse.setMessage("user authenticated");
			customResponse.setResults(socialClass);
			 
			
			
	        }
		return customResponse;
		}
		
	
}
	    //CustomResponse CustomResponse=new CustomResponse();
	  
		
	/*@GetMapping("/authenticate")
	
		public Object authorizeGet(@Valid @RequestBody LoginVM loginVM)
		{
			return loginVM;
			
			
			
		}
	}*/
	   
	

	/**
	 * Object to return as body in JWT Authentication.
	 */
	class JWTToken {

		private String Token;

		JWTToken(String Token) {
			this.Token = Token;
		}

		@JsonProperty("token")
		String getIdToken() {
			return Token;
		}

		void setIdToken(String idToken) {
			this.Token = idToken;
		}
	}

