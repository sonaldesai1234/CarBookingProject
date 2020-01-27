package com.mycipl.repository;


import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mycipl.domain.CarBookingsCollection;
import com.mycipl.domain.CityCollection;


/**
 * Spring Data MongoDB repository for the CityCollection entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CityCollectionRepository extends MongoRepository<CityCollection, String> {

	CityCollection findOneById(String id);

	CityCollection findOneByCityName(String cityName);

	
	
}
