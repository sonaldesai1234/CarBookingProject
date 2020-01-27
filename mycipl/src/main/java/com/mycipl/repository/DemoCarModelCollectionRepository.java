package com.mycipl.repository;


import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mycipl.domain.DealerCollection;
import com.mycipl.domain.DemoCarModelCollection;


/**
 * Spring Data MongoDB repository for the DemoCarModelCollection entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DemoCarModelCollectionRepository extends MongoRepository<DemoCarModelCollection, String> {

	List<DemoCarModelCollection> findByDealerCode(String dealerCode);

	List<DemoCarModelCollection> findOneById(String id);


}
