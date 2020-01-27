package com.mycipl.service.impl;

import com.mycipl.service.OtpCollectionService;
import com.mycipl.domain.OtpCollection;
import com.mycipl.repository.OtpCollectionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link OtpCollection}.
 */
@Service
public class OtpCollectionServiceImpl implements OtpCollectionService {

    private final Logger log = LoggerFactory.getLogger(OtpCollectionServiceImpl.class);

    private final OtpCollectionRepository otpCollectionRepository;

    public OtpCollectionServiceImpl(OtpCollectionRepository otpCollectionRepository) {
        this.otpCollectionRepository = otpCollectionRepository;
    }

    /**
     * Save a otpCollection.
     *
     * @param otpCollection the entity to save.
     * @return the persisted entity.
     */
    @Override
    public OtpCollection save(OtpCollection otpCollection) {
        log.debug("Request to save OtpCollection : {}", otpCollection);
        return otpCollectionRepository.save(otpCollection);
    }

    /**
     * Get all the otpCollections.
     *
     * @return the list of entities.
     */
    @Override
    public List<OtpCollection> findAll() {
        log.debug("Request to get all OtpCollections");
        return otpCollectionRepository.findAll();
    }


    /**
     * Get one otpCollection by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    public Optional<OtpCollection> findOne(String id) {
        log.debug("Request to get OtpCollection : {}", id);
        return otpCollectionRepository.findById(id);
    }

    /**
     * Delete the otpCollection by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete OtpCollection : {}", id);
        otpCollectionRepository.deleteById(id);
    }


	@Override
	public OtpCollection findByDseLoginId(String dseLoginId) {
		// TODO Auto-generated method stub
		return otpCollectionRepository.findByDseLoginId(dseLoginId);
	}

	@Override
	public OtpCollection findByOtp(String otp) {
		// TODO Auto-generated method stub
		return otpCollectionRepository.findByOtp(otp);
	}

	@Override
	public OtpCollection findOneByDseLoginId(String dseLoginId) {
		// TODO Auto-generated method stub
		return otpCollectionRepository.findOneByDseLoginId(dseLoginId);
	}

	@Override
	public OtpCollection findByDseLoginIdAndOtp(String dseLoginId,String otp) {
		// TODO Auto-generated method stub
		return otpCollectionRepository.findByDseLoginIdAndOtp(dseLoginId,otp);
	}
}
