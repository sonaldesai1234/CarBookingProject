package com.mycipl.repository;

import com.mycipl.domain.OtpCollection;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data MongoDB repository for the OtpCollection entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OtpCollectionRepository extends MongoRepository<OtpCollection, String> {

	

	OtpCollection findByDseLoginId(String dseLoginId);

	OtpCollection findByOtp(String otp);

	OtpCollection findOneByDseLoginId(String dseLoginId);

	OtpCollection findByDseLoginIdAndOtp(String dseLoginId, String otp2);

}
