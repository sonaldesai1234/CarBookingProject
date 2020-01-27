package com.mycipl.service;

import com.mycipl.domain.DealerCollection;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

/**
 * Service Interface for managing {@link DealerCollection}.
 */
public interface DealerCollectionService {

    /**
     * Save a dealerCollection.
     *
     * @param dealerCollection the entity to save.
     * @return the persisted entity.
     */
    DealerCollection save(DealerCollection dealerCollection);

    /**
     * Get all the dealerCollections.
     *
     * @return the list of entities.
     */
    List<DealerCollection> findAll();


    /**
     * Get the "id" dealerCollection.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DealerCollection> findOne(String id);

    /**
     * Delete the "id" dealerCollection.
     *
     * @param id the id of the entity.
     */
    void delete(String id);

	List<DealerCollection> findByDealerCode(String dealerCode);

	

	List<DealerCollection> findByDealerCodeIn(List<String> dealerCode);

	

	List<DealerCollection> findByCityName(String cityName);

	List<DealerCollection> findAllByDealerCode(String dealerCode);

	DealerCollection findOneByDealerCode(String dealerCode);
}
