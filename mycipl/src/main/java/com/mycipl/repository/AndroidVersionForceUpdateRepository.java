package com.mycipl.repository;

import com.mycipl.domain.AndroidVersionForceUpdate;
import com.mycipl.domain.DemoCarModelCollection;

import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data MongoDB repository for the AndroidVersionForceUpdate entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AndroidVersionForceUpdateRepository extends MongoRepository<AndroidVersionForceUpdate, String> {

	//AndroidVersionForceUpdate findOneById(String id);

	//List<AndroidVersionForceUpdate> findById(String id);

	AndroidVersionForceUpdate findOneById(String id);

	

	
}
