package com.mycipl.repository;

import com.mycipl.domain.DSExecutive;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data MongoDB repository for the DSExecutive entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DSExecutiveRepository extends MongoRepository<DSExecutive, String> {

}
