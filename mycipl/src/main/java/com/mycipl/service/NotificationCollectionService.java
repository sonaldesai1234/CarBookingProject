package com.mycipl.service;

import com.mycipl.domain.CityCollection;
import com.mycipl.domain.NotificationCollection;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link NotificationCollection}.
 */
public interface NotificationCollectionService {

    /**
     * Save a notificationCollection.
     *
     * @param notificationCollection the entity to save.
     * @return the persisted entity.
     */
    NotificationCollection save(NotificationCollection notificationCollection);

    /**
     * Get all the notificationCollections.
     *
     * @return the list of entities.
     */
    List<NotificationCollection> findAll();


    /**
     * Get the "id" notificationCollection.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
 

    /**
     * Delete the "id" notificationCollection.
     *
     * @param id the id of the entity.
     */
    void delete(String id);

	

	List<NotificationCollection> findByToAndSendingDateBetween(String to, Instant instantstart, Instant endinstant);

	NotificationCollection findOneById(String id);

	

	
	
	
	

}
