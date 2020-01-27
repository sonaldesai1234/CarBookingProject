package com.mycipl.service.impl;

import com.mycipl.service.CityCollectionService;
import com.mycipl.domain.CarBookingsCollection;
import com.mycipl.domain.CityCollection;
import com.mycipl.repository.CityCollectionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link CityCollection}.
 */
@Service
public class CityCollectionServiceImpl implements CityCollectionService {

    private final Logger log = LoggerFactory.getLogger(CityCollectionServiceImpl.class);

    private final CityCollectionRepository cityCollectionRepository;

    public CityCollectionServiceImpl(CityCollectionRepository cityCollectionRepository) {
        this.cityCollectionRepository = cityCollectionRepository;
    }

    /**
     * Save a cityCollection.
     *
     * @param cityCollection the entity to save.
     * @return the persisted entity.
     */
    @Override
    public CityCollection save(CityCollection cityCollection) {
        log.debug("Request to save CityCollection : {}", cityCollection);
        return cityCollectionRepository.save(cityCollection);
    }

    /**
     * Get all the cityCollections.
     *
     * @return the list of entities.
     */
    @Override
    public List<CityCollection> findAll() {
        log.debug("Request to get all CityCollections");
        return cityCollectionRepository.findAll();
    }


    /**
     * Get one cityCollection by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
  

    /**
     * Delete the cityCollection by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete CityCollection : {}", id);
        cityCollectionRepository.deleteById(id);
    }



	@Override
	public CityCollection findOneByCityName(String cityName) {
		// TODO Auto-generated method stub
		return cityCollectionRepository.findOneByCityName(cityName);
	}

	@Override
	public CityCollection findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CityCollection findOneById(String id) {
		// TODO Auto-generated method stub
		return cityCollectionRepository.findOneById(id);
	}


	

	
}
