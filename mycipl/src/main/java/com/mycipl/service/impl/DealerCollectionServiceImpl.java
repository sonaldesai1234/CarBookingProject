package com.mycipl.service.impl;

import com.mycipl.service.DealerCollectionService;
import com.mycipl.domain.DealerCollection;
import com.mycipl.repository.DealerCollectionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link DealerCollection}.
 */
@Service
public class DealerCollectionServiceImpl implements DealerCollectionService {

    private final Logger log = LoggerFactory.getLogger(DealerCollectionServiceImpl.class);

    private final DealerCollectionRepository dealerCollectionRepository;

    public DealerCollectionServiceImpl(DealerCollectionRepository dealerCollectionRepository) {
        this.dealerCollectionRepository = dealerCollectionRepository;
    }

    /**
     * Save a dealerCollection.
     *
     * @param dealerCollection the entity to save.
     * @return the persisted entity.
     */
    @Override
    public DealerCollection save(DealerCollection dealerCollection) {
        log.debug("Request to save DealerCollection : {}", dealerCollection);
        return dealerCollectionRepository.save(dealerCollection);
    }

    /**
     * Get all the dealerCollections.
     *
     * @return the list of entities.
     */
    @Override
    public List<DealerCollection> findAll() {
        log.debug("Request to get all DealerCollections");
        return dealerCollectionRepository.findAll();
    }


    /**
     * Get one dealerCollection by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    public Optional<DealerCollection> findOne(String id) {
        log.debug("Request to get DealerCollection : {}", id);
        return dealerCollectionRepository.findById(id);
    }

    /**
     * Delete the dealerCollection by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete DealerCollection : {}", id);
        dealerCollectionRepository.deleteById(id);
    }
    
    @Override
   public List<DealerCollection> findByDealerCode(String dealerCode)
   
    {    log.debug("Request to delete DealerCollection : {}", dealerCode);
    	 return dealerCollectionRepository.findByDealerCode(dealerCode);
    }
    
    
    @Override
    public List<DealerCollection> findByDealerCodeIn(List<String> dealerCode)
    {
    	return findByDealerCodeIn(dealerCode);
    }

	

	@Override
	public List<DealerCollection> findByCityName(String cityName) {
		// TODO Auto-generated method stub
		return dealerCollectionRepository.findByCityName(cityName);
	}

	@Override
	public List<DealerCollection> findAllByDealerCode(String dealerCode) {
		// TODO Auto-generated method stub
		return dealerCollectionRepository.findAllByDealerCode(dealerCode);
	}

	@Override
	public DealerCollection findOneByDealerCode(String dealerCode) {
		// TODO Auto-generated method stub
		return dealerCollectionRepository.findOneByDealerCode(dealerCode);
	}

}
