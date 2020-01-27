package com.mycipl.service;

import com.mycipl.domain.DSExecutive;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link DSExecutive}.
 */
public interface DSExecutiveService {

    /**
     * Save a dSExecutive.
     *
     * @param dSExecutive the entity to save.
     * @return the persisted entity.
     */
    DSExecutive save(DSExecutive dSExecutive);

    /**
     * Get all the dSExecutives.
     *
     * @return the list of entities.
     */
    List<DSExecutive> findAll();


    /**
     * Get the "id" dSExecutive.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DSExecutive> findOne(String id);

    /**
     * Delete the "id" dSExecutive.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
