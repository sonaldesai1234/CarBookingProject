package com.mycipl.repository;


import org.springframework.data.mongodb.repository.Query;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mycipl.domain.DealerCollection;
import com.mycipl.domain.DemoCarModelCollection;


/**
 * Spring Data MongoDB repository for the DealerCollection entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DealerCollectionRepository extends MongoRepository<DealerCollection, String> {

	List<DealerCollection> findByDealerCode(String dealerCode);
	List<DealerCollection> findByDealerCodeIn(List<String> dealerCode);
	List<DealerCollection> findByCityName(String cityName);
	List<DealerCollection> findAllByDealerCode(String dealerCode);
	DealerCollection findOneByDealerCode(String dealerCode);

}
