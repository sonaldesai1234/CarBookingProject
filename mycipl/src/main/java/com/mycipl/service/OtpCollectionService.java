package com.mycipl.service;

import com.mycipl.domain.OtpCollection;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link OtpCollection}.
 */
public interface OtpCollectionService {

    /**
     * Save a otpCollection.
     *
     * @param otpCollection the entity to save.
     * @return the persisted entity.
     */
    OtpCollection save(OtpCollection otpCollection);

    /**
     * Get all the otpCollections.
     *
     * @return the list of entities.
     */
    List<OtpCollection> findAll();


    /**
     * Get the "id" otpCollection.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<OtpCollection> findOne(String id);

    /**
     * Delete the "id" otpCollection.
     *
     * @param id the id of the entity.
     */
    void delete(String id);

   

	OtpCollection findByDseLoginId(String dseLoginId);

	OtpCollection findByOtp(String otp);

	OtpCollection findOneByDseLoginId(String dseLoginId);

	OtpCollection findByDseLoginIdAndOtp(String dseLoginId, String otp2);
}
