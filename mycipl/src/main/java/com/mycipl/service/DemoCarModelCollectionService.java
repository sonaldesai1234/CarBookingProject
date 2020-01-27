package com.mycipl.service;

import  com.mycipl.domain.DemoCarModelCollection;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link DemoCarModelCollection}.
 */
public interface DemoCarModelCollectionService {

    /**
     * Save a demoCarModelCollection.
     *
     * @param demoCarModelCollection the entity to save.
     * @return the persisted entity.
     */
    com.mycipl.domain.DemoCarModelCollection save(DemoCarModelCollection demoCarModelCollection);

    /**
     * Get all the demoCarModelCollections.
     *
     * @return the list of entities.
     */
    List<DemoCarModelCollection> findAll();


    /**
     * Get the "id" demoCarModelCollection.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DemoCarModelCollection> findOne(String id);

    /**
     * Delete the "id" demoCarModelCollection.
     *
     * @param id the id of the entity.
     */
    void delete(String id);

	List<DemoCarModelCollection> findByDealerCode(String dealerCode);

	List<DemoCarModelCollection> findOneById(String id);

	DemoCarModelCollection findByCarModelColourAndcarModelName(String carModelColour, String carModelName);
}
