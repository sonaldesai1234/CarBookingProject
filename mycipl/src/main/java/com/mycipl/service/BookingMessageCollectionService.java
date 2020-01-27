package com.mycipl.service;

import com.mycipl.domain.BookingMessageCollection;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link BookingMessageCollection}.
 */
public interface BookingMessageCollectionService {

    /**
     * Save a bookingMessageCollection.
     *
     * @param bookingMessageCollection the entity to save.
     * @return the persisted entity.
     */
    BookingMessageCollection save(BookingMessageCollection bookingMessageCollection);

    /**
     * Get all the bookingMessageCollections.
     *
     * @return the list of entities.
     */
    List<BookingMessageCollection> findAll();


    /**
     * Get the "id" bookingMessageCollection.
     *
     * @param id the id of the entity.
     * @return the entity.
     */

    /**
     * Delete the "id" bookingMessageCollection.
     *
     * @param id the id of the entity.
     */
    void delete(String id);

	List<BookingMessageCollection> findOneById(String id);
}
