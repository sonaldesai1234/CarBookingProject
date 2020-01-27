package com.mycipl.repository;

import com.mycipl.domain.CarBook;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data MongoDB repository for the CarBook entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CarBookRepository extends MongoRepository<CarBook, String> {

}
