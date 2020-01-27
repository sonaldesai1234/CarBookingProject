package com.mycipl.service;

import com.mycipl.domain.UserProfile;
import com.mycipl.web.rest.UserProfileResource;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing UserProfile.
 */
public interface UserProfileService {

    /**
     * Save a userProfile.
     *
     * @param userProfile the entity to save
     * @return the persisted entity
     */
    UserProfile save(UserProfile userProfile);

    /**
     * Get all the userProfiles.
     *
     * @return the list of entities
     */
    List<UserProfile> findAll();


    /**
     * Get the "id" userProfile.
     *
     * @param id the id of the entity
     * @return the entity
     */
    //List<UserProfile> findOne(String id);

    /**
     * Delete the "id" userProfile.
     *
     * @param id the id of the entity
     */
    void delete(String id);

	List<UserProfile> findByDseLoginIdAndDsePassword(String dseLoginId, String dsePassword);


	List<UserProfile> findByRoleAndDealerCodeAndTeamLeader(String role, String dealerCode, String teamLeader);

	UserProfile findByDseLoginId(String dseLoginId);

	List<UserProfile> findByDealerCodeAndTeamLeader(String dealerCode, String teamLeader);

	List<UserProfile> findByDealerCode(String dealerCode);

	List<UserProfile> findByTeamLeader(String teamLeader);

	List<UserProfile> findByDealerCodeAndRole(String dealerCode, String role);

	
	List<UserProfile> findByRoleAndDealerCode(String role, String dealerCode);

	//UserProfile findByDseLoginIdAndDealerCode(String dseLoginId, String dealerCode);

	
	}

