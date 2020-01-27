package com.mycipl.service.impl;

import com.mycipl.service.NotificationSchedulerCollectionService;
import com.mycipl.domain.NotificationSchedulerCollection;
import com.mycipl.repository.NotificationSchedulerCollectionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link NotificationSchedulerCollection}.
 */
@Service
public class NotificationSchedulerCollectionServiceImpl implements NotificationSchedulerCollectionService {

    private final Logger log = LoggerFactory.getLogger(NotificationSchedulerCollectionServiceImpl.class);

    private final NotificationSchedulerCollectionRepository notificationSchedulerCollectionRepository;

    public NotificationSchedulerCollectionServiceImpl(NotificationSchedulerCollectionRepository notificationSchedulerCollectionRepository) {
        this.notificationSchedulerCollectionRepository = notificationSchedulerCollectionRepository;
    }

    /**
     * Save a notificationSchedulerCollection.
     *
     * @param notificationSchedulerCollection the entity to save.
     * @return the persisted entity.
     */
    @Override
    public NotificationSchedulerCollection save(NotificationSchedulerCollection notificationSchedulerCollection) {
        log.debug("Request to save NotificationSchedulerCollection : {}", notificationSchedulerCollection);
        return notificationSchedulerCollectionRepository.save(notificationSchedulerCollection);
    }

    /**
     * Get all the notificationSchedulerCollections.
     *
     * @return the list of entities.
     */
    @Override
    public List<NotificationSchedulerCollection> findAll() {
        log.debug("Request to get all NotificationSchedulerCollections");
        return notificationSchedulerCollectionRepository.findAll();
    }


    /**
     * Get one notificationSchedulerCollection by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    public Optional<NotificationSchedulerCollection> findOne(String id) {
        log.debug("Request to get NotificationSchedulerCollection : {}", id);
        return notificationSchedulerCollectionRepository.findById(id);
    }

    /**
     * Delete the notificationSchedulerCollection by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete NotificationSchedulerCollection : {}", id);
        notificationSchedulerCollectionRepository.deleteById(id);
    }
}
