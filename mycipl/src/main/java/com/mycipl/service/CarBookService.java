package com.mycipl.service;

import com.mycipl.domain.CarBook;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link CarBook}.
 */
public interface CarBookService {

    /**
     * Save a carBook.
     *
     * @param carBook the entity to save.
     * @return the persisted entity.
     */
    CarBook save(CarBook carBook);

    /**
     * Get all the carBooks.
     *
     * @return the list of entities.
     */
    List<CarBook> findAll();


    /**
     * Get the "id" carBook.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CarBook> findOne(String id);

    /**
     * Delete the "id" carBook.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
