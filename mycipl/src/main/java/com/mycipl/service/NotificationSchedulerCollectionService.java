package com.mycipl.service;

import com.mycipl.domain.NotificationSchedulerCollection;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link NotificationSchedulerCollection}.
 */
public interface NotificationSchedulerCollectionService {

    /**
     * Save a notificationSchedulerCollection.
     *
     * @param notificationSchedulerCollection the entity to save.
     * @return the persisted entity.
     */
    NotificationSchedulerCollection save(NotificationSchedulerCollection notificationSchedulerCollection);

    /**
     * Get all the notificationSchedulerCollections.
     *
     * @return the list of entities.
     */
    List<NotificationSchedulerCollection> findAll();


    /**
     * Get the "id" notificationSchedulerCollection.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<NotificationSchedulerCollection> findOne(String id);

    /**
     * Delete the "id" notificationSchedulerCollection.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
