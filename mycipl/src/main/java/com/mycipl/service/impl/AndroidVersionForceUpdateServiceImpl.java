package com.mycipl.service.impl;

import com.mycipl.service.AndroidVersionForceUpdateService;
import com.mycipl.domain.AndroidVersionForceUpdate;
import com.mycipl.repository.AndroidVersionForceUpdateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Service Implementation for managing {@link AndroidVersionForceUpdate}.
 */
@Service
public class AndroidVersionForceUpdateServiceImpl implements AndroidVersionForceUpdateService {

    private final Logger log = LoggerFactory.getLogger(AndroidVersionForceUpdateServiceImpl.class);

    private final AndroidVersionForceUpdateRepository androidVersionForceUpdateRepository;

    public AndroidVersionForceUpdateServiceImpl(AndroidVersionForceUpdateRepository androidVersionForceUpdateRepository) {
        this.androidVersionForceUpdateRepository = androidVersionForceUpdateRepository;
    }

    /**
     * Save a androidVersionForceUpdate.
     *
     * @param androidVersionForceUpdate the entity to save.
     * @return the persisted entity.
     */
   

    /**
     * Get all the androidVersionForceUpdates.
     *
     * @return the list of entities.
     */
    @Override
    public List<AndroidVersionForceUpdate> findAll() {
        log.debug("Request to get all AndroidVersionForceUpdates");
        return androidVersionForceUpdateRepository.findAll();
    }


    /**
     * Get one androidVersionForceUpdate by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    /*@Override
    public List<AndroidVersionForceUpdate> findOne(String id) {
        log.debug("Request to get AndroidVersionForceUpdate : {}", id);
        return androidVersionForceUpdateRepository.findOne(id);
    }*/

    /**
     * Delete the androidVersionForceUpdate by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete AndroidVersionForceUpdate : {}", id);
        androidVersionForceUpdateRepository.deleteById(id);
    }

	@Override
	public AndroidVersionForceUpdate findByOwner(String owner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AndroidVersionForceUpdate findOneById(String id) {
		// TODO Auto-generated method stub
		return androidVersionForceUpdateRepository.findOneById(id);
	}

	@Override
	public AndroidVersionForceUpdate save(AndroidVersionForceUpdate androidVersionForceUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AndroidVersionForceUpdate> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}



	

	

	
	

	
	
	

	
	
	

	
	
 
   
}
