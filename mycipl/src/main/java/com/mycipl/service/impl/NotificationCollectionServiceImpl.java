package com.mycipl.service.impl;

import com.mycipl.service.NotificationCollectionService;
import com.mycipl.domain.CityCollection;
import com.mycipl.domain.NotificationCollection;
import com.mycipl.repository.NotificationCollectionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link NotificationCollection}.
 */
@Service
public class NotificationCollectionServiceImpl implements NotificationCollectionService {

    private final Logger log = LoggerFactory.getLogger(NotificationCollectionServiceImpl.class);

    private final NotificationCollectionRepository notificationCollectionRepository;

    public NotificationCollectionServiceImpl(NotificationCollectionRepository notificationCollectionRepository) {
        this.notificationCollectionRepository = notificationCollectionRepository;
    }

    /**
     * Save a notificationCollection.
     *
     * @param notificationCollection the entity to save.
     * @return the persisted entity.
     */
    @Override
    public NotificationCollection save(NotificationCollection notificationCollection) {
        log.debug("Request to save NotificationCollection : {}", notificationCollection);
        return notificationCollectionRepository.save(notificationCollection);
    }

    /**
     * Get all the notificationCollections.
     *
     * @return the list of entities.
     */
    @Override
    public List<NotificationCollection> findAll() {
        log.debug("Request to get all NotificationCollections");
        return notificationCollectionRepository.findAll();
    }


    /**
     * Get one notificationCollection by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    
    /**
     * Delete the notificationCollection by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete NotificationCollection : {}", id);
        notificationCollectionRepository.deleteById(id);
    }


	
	

	@Override
	public List<NotificationCollection> findByToAndSendingDateBetween(String to, Instant instantstart,
			Instant endinstant) {
	
		return notificationCollectionRepository.findByToAndSendingDateBetween(to,instantstart,
				endinstant);
	}

	@Override
	public NotificationCollection findOneById(String id) {
		// TODO Auto-generated method stub
		return notificationCollectionRepository.findOneById(id);
	}

	
	
	

}
