package com.mycipl.service;


import java.util.List;
import java.util.Optional;

import com.mycipl.domain.CityCollection;

/**
 * Service Interface for managing {@link CityCollection}.
 */
public interface CityCollectionService {

    /**
     * Save a cityCollection.
     *
     * @param cityCollection the entity to save.
     * @return the persisted entity.
     */
  public   CityCollection save(CityCollection cityCollection);

    /**
     * Get all the cityCollections.
     *
     * @return the list of entities.
     */
  public   List<CityCollection> findAll();


    /**
     * Get the "id" cityCollection.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
 public   CityCollection findOne(String id);

    /**
     * Delete the "id" cityCollection.
     *
     * @param id the id of the entity.
     */
    void delete(String id);

	public CityCollection findOneById(String id);

	public CityCollection findOneByCityName(String cityName);
}
