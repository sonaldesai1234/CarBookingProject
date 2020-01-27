package com.mycipl.service;

import com.mycipl.domain.AndroidVersionForceUpdate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Service Interface for managing {@link AndroidVersionForceUpdate}.
 */
public interface AndroidVersionForceUpdateService {

    /**
     * Save a androidVersionForceUpdate.
     *
     * @param androidVersionForceUpdate the entity to save.
     * @return the persisted entity.
     */
   public AndroidVersionForceUpdate save(AndroidVersionForceUpdate androidVersionForceUpdate);

    /**
     * Get all the androidVersionForceUpdates.
     *
     * @return the list of entities.
     */
    List<AndroidVersionForceUpdate> findAll();


    /**
     * Get the "id" androidVersionForceUpdate.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
  //  List<AndroidVersionForceUpdate> findOne(String id);

    /**
     * Delete the "id" androidVersionForceUpdate.
     *
     * @param id the id of the entity.
     */
    void delete(String id);

	

	AndroidVersionForceUpdate findByOwner(String owner);


	List<AndroidVersionForceUpdate> findById(String id);

	AndroidVersionForceUpdate findOneById(String id);



	
}
