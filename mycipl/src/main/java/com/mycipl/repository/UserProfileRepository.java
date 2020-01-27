package com.mycipl.repository;

import com.mycipl.domain.UserProfile;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data MongoDB repository for the UserProfile entity.
 */
 
 
@SuppressWarnings("unused")
@Repository
public interface UserProfileRepository extends MongoRepository<UserProfile, String> {

	List<UserProfile> findByDseLoginIdAndDsePassword(String dseLoginId, String dsePassword);


	List<UserProfile> findByRoleAndDealerCodeAndTeamLeader(String role, String dealerCode, String teamLeader);

	//List<UserProfile> findOne(String id);

	UserProfile findByDseLoginId(String dseLoginId);


	List<UserProfile> findByDealerCodeAndTeamLeader(String dealerCode, String teamLeader);


	List<UserProfile> findByDealerCode(String dealerCode);


	List<UserProfile> findByTeamLeader(String teamLeader);

	/*@Query("{'dseLoginId':?0 ,'dealerCode':?1}")
	UserProfile findByDseLoginIdAndDealerCode(String dseLoginId, String dealerCode);*/

	List<UserProfile> findByDealerCodeAndDseLoginId(String dealerCode, String dseLoginId);


	

	UserProfile findOneById(String id);


	List<UserProfile> findByDealerCodeAndRole(String dealerCode, String role);


	

	List<UserProfile> findByRoleAndDealerCode(String role, String dealerCode);


	 Optional<UserProfile> findOneWithAuthoritiesByDseLoginId(String dseLoginId);
		// TODO Auto-generated method stub


		




}
