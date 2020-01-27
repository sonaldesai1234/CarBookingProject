package com.mycipl.service.impl;

import com.mycipl.service.DemoCarModelCollectionService;
import com.mycipl.domain.DemoCarModelCollection;
import com.mycipl.repository.DemoCarModelCollectionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link DemoCarModelCollection}.
 */
@Service
public class DemoCarModelCollectionServiceImpl implements DemoCarModelCollectionService {

    private final Logger log = LoggerFactory.getLogger(DemoCarModelCollectionServiceImpl.class);

    private final DemoCarModelCollectionRepository demoCarModelCollectionRepository;

    public DemoCarModelCollectionServiceImpl(DemoCarModelCollectionRepository demoCarModelCollectionRepository) {
        this.demoCarModelCollectionRepository = demoCarModelCollectionRepository;
    }

    /**
     * Save a demoCarModelCollection.
     *
     * @param demoCarModelCollection the entity to save.
     * @return the persisted entity.
     */
    @Override
    public DemoCarModelCollection save(DemoCarModelCollection demoCarModelCollection) {
        log.debug("Request to save DemoCarModelCollection : {}", demoCarModelCollection);
        return demoCarModelCollectionRepository.save(demoCarModelCollection);
    }

    /**
     * Get all the demoCarModelCollections.
     *
     * @return the list of entities.
     */
    @Override
    public List<DemoCarModelCollection> findAll() {
        log.debug("Request to get all DemoCarModelCollections");
        return demoCarModelCollectionRepository.findAll();
    }


    /**
     * Get one demoCarModelCollection by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    public Optional<DemoCarModelCollection> findOne(String id) {
        log.debug("Request to get DemoCarModelCollection : {}", id);
        return demoCarModelCollectionRepository.findById(id);
    }

    /**
     * Delete the demoCarModelCollection by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete DemoCarModelCollection : {}", id);
        demoCarModelCollectionRepository.deleteById(id);
    }
    
   public List<DemoCarModelCollection> findByDealerCode(String dealerCode)
   {
	   return demoCarModelCollectionRepository.findByDealerCode(dealerCode);
   }

@Override
public List<DemoCarModelCollection> findOneById(String id) {
	// TODO Auto-generated method stub
	return demoCarModelCollectionRepository.findOneById(id);
}

@Override
public DemoCarModelCollection findByCarModelColourAndcarModelName(String carModelColour, String carModelName) {
	// TODO Auto-generated method stub
	return null;
}


  
 
}
