package com.mycipl.repository;

import com.mycipl.domain.CityCollection;
import com.mycipl.domain.NotificationCollection;
import org.springframework.data.mongodb.repository.Query;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data MongoDB repository for the NotificationCollection entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NotificationCollectionRepository extends MongoRepository<NotificationCollection, String> {

	

	List<NotificationCollection> findByToAndSendingDateBetween(String to,Instant startDate, Instant endDate);

	NotificationCollection findOneById(String id);

	
	

	


}
