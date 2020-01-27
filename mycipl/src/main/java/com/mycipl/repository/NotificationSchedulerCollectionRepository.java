package com.mycipl.repository;

import com.mycipl.domain.NotificationSchedulerCollection;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data MongoDB repository for the NotificationSchedulerCollection entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NotificationSchedulerCollectionRepository extends MongoRepository<NotificationSchedulerCollection, String> {

}
