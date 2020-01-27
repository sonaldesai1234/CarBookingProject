package com.mycipl.service.impl;

import com.mycipl.service.UserProfileService;
import com.mycipl.service.dto.UserProfileDTO;
import com.mycipl.service.util.RandomUtil;

import com.mycipl.domain.Authority;
import com.mycipl.domain.User;
import com.mycipl.domain.UserProfile;
import com.mycipl.repository.UserProfileRepository;
import com.mycipl.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Service Implementation for managing UserProfile.
 */
@Service
public class UserProfileServiceImpl implements UserProfileService {

	private final Logger log = LoggerFactory.getLogger(UserProfileServiceImpl.class);

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userRepository;
	

	private final UserProfileRepository userProfileRepository;

	public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
		this.userProfileRepository = userProfileRepository;
	}

	/**
	 * Save a userProfile.
	 *
	 * @param userProfile
	 *            the entity to save
	 * @return the persisted entity
	 */
	@Override
	public UserProfile save(UserProfile userProfile) {
		log.debug("Request to save UserProfile : {}", userProfile);
		return userProfileRepository.save(userProfile);
	}

	/**
	 * Get all the userProfiles.
	 *
	 * @return the list of entities
	 */
	@Override
	public List<UserProfile> findAll() {
		log.debug("Request to get all UserProfiles");
		return userProfileRepository.findAll();
	}

	/**
	 * Get one userProfile by id.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	
	

	/**
	 * Delete the userProfile by id.
	 *
	 * @param id
	 *            the id of the entity
	 */
	@Override
	public void delete(String id) {
		log.debug("Request to delete UserProfile : {}", id);
		userProfileRepository.deleteById(id);
	}

	public UserProfile createUser(UserProfileDTO userProfileDTO) {

		User user = new User();

		user.setDseName(userProfileDTO.getDseName().toLowerCase());
		
		user.setDseLoginId(userProfileDTO.getDseLoginId());

		String encryptedPassword = passwordEncoder.encode(userProfileDTO.getDsePassword());
		user.setPassword(encryptedPassword);
		
	
		user.setDseMobileNumber(userProfileDTO.getDseMobileNumber());
		
		user.setDealerCode(userProfileDTO.getDealerCode());
		
		
		user.setdLastLogin(userProfileDTO.getdLastLogin());	
		
		user.setTeamLeader(userProfileDTO.getTeamLeader().toLowerCase());
		
		user.setDseName(userProfileDTO.getDseName());
		
		user.setCreatedBy(userProfileDTO.getCreatedBy());
		
		user.setUpdatedBy(userProfileDTO.getUpdatedBy());
		
		user.setUpdatedOn(userProfileDTO.getUpdatedOn());
		user.setCreatedOn(userProfileDTO.getCreatedOn());
		

		user.setEmail(userProfileDTO.getEmail().toLowerCase());
		
		
		if(userProfileDTO.getDealerName() !=null && ! userProfileDTO.getDealerName().isEmpty()) {
		user.setDealerName(userProfileDTO.getDealerName());
		}
		
		if(userProfileDTO.getDealerLocation() !=null && ! userProfileDTO.getDealerLocation().isEmpty()) {
		user.setDealerLocation(userProfileDTO.getDealerLocation().toLowerCase());
		}
		

		user.setPasswordChange(userProfileDTO.getPasswordChange());
		

		user.setAccountLocked(userProfileDTO.getAccountLocked());
		user.setIsActive(userProfileDTO.getIsActive());
		user.setResetKey(RandomUtil.generateResetKey());
		user.setResetDate(Instant.now());
		user.setActivated(true);

		Authority authority = new Authority();
		Set<Authority> authorities = new HashSet<>();

		for (String role : userProfileDTO.getRole()) {
			authority = new Authority();
			authority.setName("ROLE_"+role.toUpperCase());
			System.out.println(authority.getName());
			authorities.add(authority);
		}
		
		user.setAuthorities(authorities);
		user.setRole(userProfileDTO.getRole());
		userRepository.save(user);
		
		
		
		UserProfile userProfile=new UserProfile();
		
		userProfile.setDseLoginId(userProfileDTO.getDseLoginId());
		userProfile.setDseName(userProfileDTO.getDseName());
		userProfile.setEmail(userProfileDTO.getEmail());
		userProfile.setDealerName(userProfileDTO.getDealerName());
		userProfile.setDealerLocation(userProfileDTO.getDealerLocation());
		userProfile.setDealerCode(userProfileDTO.getDealerCode());
		userProfile.setRole(userProfileDTO.getRole());
		userProfile.setTeamLeader(userProfileDTO.getTeamLeader());
		userProfile.setCreatedBy(userProfileDTO.getCreatedBy());
		userProfile.setCreatedOn(userProfileDTO.getCreatedOn());
		userProfile.setUpdatedBy(userProfileDTO.getUpdatedBy());
		userProfile.setUpdatedOn(userProfileDTO.getUpdatedOn());
		userProfile.setPasswordChange(userProfileDTO.getPasswordChange());
		userProfile.setAccountLocked(userProfileDTO.getAccountLocked());		
		userProfile.setdLastLogin(userProfileDTO.getdLastLogin());
		userProfile.setDseMobileNumber(userProfileDTO.getDseMobileNumber());
		userProfile.setIsActive(userProfileDTO.getIsActive());
		return userProfileRepository.save(userProfile);
		
	}

	

	@Override
	public List<UserProfile> findByRoleAndDealerCodeAndTeamLeader(String role, String dealerCode,
			String teamLeader) {
		// TODO Auto-generated method stub
		return userProfileRepository.findByRoleAndDealerCodeAndTeamLeader(role, dealerCode,
				teamLeader);
	}
	/*public List<UserProfile> findOne(String id) {
		log.debug("Request to get UserProfile : {}", id);
		return userProfileRepository.findOne(id);
	}*/

	@Override
	public UserProfile findByDseLoginId(String dseLoginId) {
		// TODO Auto-generated method stub
		return userProfileRepository.findByDseLoginId(dseLoginId);
	}

	@Override
	public List<UserProfile> findByDseLoginIdAndDsePassword(String dseLoginId, String dsePassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserProfile> findByDealerCodeAndTeamLeader(String dealerCode, String teamLeader) {
		
		return userProfileRepository.findByDealerCodeAndTeamLeader(dealerCode,teamLeader);
	}

	@Override
	public List<UserProfile> findByDealerCode(String dealerCode) {
		// TODO Auto-generated method stub
		return userProfileRepository.findByDealerCode(dealerCode);
	}

	@Override
	public List<UserProfile> findByTeamLeader(String teamLeader) {
		// TODO Auto-generated method stub
		return userProfileRepository.findByTeamLeader(teamLeader);
	}

	public UserProfile updateUser(UserProfile userProfileDTO) {
		User user = new User();
		
		
/*
		
		 String dseLoginId=userProfileDTO.getDseLoginId();
		  
		 Optional<User> userObj=userRepository.findOneByDseLoginId(dseLoginId);
		 
		 String idObj=userObj.get().getId();
		 
		 user.setId(idObj);
		
		
		
		

		user.setId(userProfileDTO.getId());
		*/

		 Optional<User> userObj= userRepository.findById(userProfileDTO.getId());
		 
		user.setId(userProfileDTO.getId());

		user.setDseName(userProfileDTO.getDseName());
		
		user.setDseLoginId(userProfileDTO.getDseLoginId());
/*
		if(userProfileDTO.getDsePassword()!=null)
		{
		String encryptedPassword = passwordEncoder.encode(userProfileDTO.getDsePassword());
		user.setPassword(encryptedPassword);
		}
	*/
		user.setDseMobileNumber(userProfileDTO.getDseMobileNumber());
		
		user.setDealerCode(userProfileDTO.getDealerCode());
		
		
		user.setdLastLogin(userProfileDTO.getdLastLogin());	
		
		user.setTeamLeader(userProfileDTO.getTeamLeader());
		
		user.setDseName(userProfileDTO.getDseName());
		
		user.setCreatedBy(userProfileDTO.getCreatedBy());
		
		user.setUpdatedBy(userProfileDTO.getUpdatedBy());
		
		user.setUpdatedOn(userProfileDTO.getUpdatedOn());
		user.setCreatedOn(userProfileDTO.getCreatedOn());
		

		user.setEmail(userProfileDTO.getEmail());

		if(userProfileDTO.getDealerName() !=null && ! userProfileDTO.getDealerName().isEmpty()) {		
		user.setDealerName(userProfileDTO.getDealerName());}
		if(userProfileDTO.getDealerLocation() !=null && ! userProfileDTO.getDealerLocation().isEmpty()) {	
		user.setDealerLocation(userProfileDTO.getDealerLocation().toLowerCase());}

				
		
				
		user.setDealerName(userProfileDTO.getDealerName());
			
		user.setDealerLocation(userProfileDTO.getDealerLocation());

		
		

	//user.setPasswordChange(userProfileDTO.getPasswordChange());
		

	//user.setAccountLocked(userProfileDTO.getAccountLocked());
		user.setIsActive(userProfileDTO.getIsActive());
	user.setResetKey(RandomUtil.generateResetKey());
		user.setResetDate(Instant.now());
		user.setActivated(true);

		Authority authority = new Authority();
		Set<Authority> authorities = new HashSet<>();

		for (String role : userProfileDTO.getRole()) {
			authority = new Authority();
			authority.setName(role);
			authorities.add(authority);
		}
		
		user.setAuthorities(authorities);
		user.setRole(userProfileDTO.getRole());
		userRepository.save(user);
		
		
		
		UserProfile userProfile=new UserProfile();
		userProfile.setId(userProfileDTO.getId());
		userProfile.setDseLoginId(userProfileDTO.getDseLoginId());
		userProfile.setDseName(userProfileDTO.getDseName());
		userProfile.setEmail(userProfileDTO.getEmail());
		userProfile.setDealerName(userProfileDTO.getDealerName());
		userProfile.setDealerLocation(userProfileDTO.getDealerLocation());
		userProfile.setDealerCode(userProfileDTO.getDealerCode());
		userProfile.setRole(userProfileDTO.getRole());
		userProfile.setTeamLeader(userProfileDTO.getTeamLeader());
		userProfile.setCreatedBy(userProfileDTO.getCreatedBy());
		userProfile.setCreatedOn(userProfileDTO.getCreatedOn());
		userProfile.setUpdatedBy(userProfileDTO.getUpdatedBy());
		userProfile.setUpdatedOn(userProfileDTO.getUpdatedOn());
	//userProfile.setPasswordChange(userProfileDTO.getPasswordChange());
	//userProfile.setAccountLocked(userProfileDTO.getAccountLocked());		
		userProfile.setdLastLogin(userProfileDTO.getdLastLogin());
		userProfile.setDseMobileNumber(userProfileDTO.getDseMobileNumber());
		userProfile.setIsActive(userProfileDTO.getIsActive());
	
		return userProfileRepository.save(userProfile);
	}

	@Override
	public List<UserProfile> findByDealerCodeAndRole(String dealerCode, String role) {
		// TODO Auto-generated method stub
		return userProfileRepository.findByDealerCodeAndRole(dealerCode,role) ;
	}

	@Override
	public List<UserProfile> findByRoleAndDealerCode(String role, String dealerCode) {
		// TODO Auto-generated method stub
		return userProfileRepository.findByRoleAndDealerCode(role,dealerCode);
	}

	

/*	@Override
	public UserProfile findByDseLoginIdAndDealerCode(String dseLoginId, String dealerCode) {
		// TODO Auto-generated method stub
		return userProfileRepository.findByDseLoginIdAndDealerCode(dseLoginId, dealerCode);
	}
*/
}
