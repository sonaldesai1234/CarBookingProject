package com.mycipl.repository;

import com.mycipl.domain.User;
import com.mycipl.domain.UserProfile;
import com.mycipl.web.rest.UserResource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.time.Instant;

/**
 * Spring Data MongoDB repository for the User entity.
 */
 
 
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    String USERS_BY_LOGIN_CACHE = "usersByLogin";

    String USERS_BY_EMAIL_CACHE = "usersByEmail";

	
	


    Optional<User> findOneByActivationKey(String activationKey);

    List<User> findAllByActivatedIsFalseAndCreatedDateBefore(Instant dateTime);

    Optional<User> findOneByResetKey(String resetKey);

    @Cacheable(cacheNames = USERS_BY_EMAIL_CACHE)
    Optional<User> findOneByEmailIgnoreCase(String email);

  // Page<User> findAllByLoginNot(Pageable pageable, String login);
	

	 Optional<User> findOneByDseLoginId(String lowercaseLogin);

	 Optional<User> findOneWithAuthoritiesByDseLoginId(String dseLoginId);





	
	
	
	 
}
