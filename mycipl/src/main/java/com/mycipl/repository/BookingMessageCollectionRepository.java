package com.mycipl.repository;

import com.mycipl.domain.BookingMessageCollection;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data MongoDB repository for the BookingMessageCollection entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BookingMessageCollectionRepository extends MongoRepository<BookingMessageCollection, String> {

	List<BookingMessageCollection> findOneById(String id);

}
