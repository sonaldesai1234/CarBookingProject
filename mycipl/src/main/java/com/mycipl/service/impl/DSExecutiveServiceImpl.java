package com.mycipl.service.impl;

import com.mycipl.service.DSExecutiveService;
import com.mycipl.domain.DSExecutive;
import com.mycipl.repository.DSExecutiveRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link DSExecutive}.
 */
@Service
public class DSExecutiveServiceImpl implements DSExecutiveService {

    private final Logger log = LoggerFactory.getLogger(DSExecutiveServiceImpl.class);

    private final DSExecutiveRepository dSExecutiveRepository;

    public DSExecutiveServiceImpl(DSExecutiveRepository dSExecutiveRepository) {
        this.dSExecutiveRepository = dSExecutiveRepository;
    }

    /**
     * Save a dSExecutive.
     *
     * @param dSExecutive the entity to save.
     * @return the persisted entity.
     */
    @Override
    public DSExecutive save(DSExecutive dSExecutive) {
        log.debug("Request to save DSExecutive : {}", dSExecutive);
        return dSExecutiveRepository.save(dSExecutive);
    }

    /**
     * Get all the dSExecutives.
     *
     * @return the list of entities.
     */
    @Override
    public List<DSExecutive> findAll() {
        log.debug("Request to get all DSExecutives");
        return dSExecutiveRepository.findAll();
    }


    /**
     * Get one dSExecutive by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    public Optional<DSExecutive> findOne(String id) {
        log.debug("Request to get DSExecutive : {}", id);
        return dSExecutiveRepository.findById(id);
    }

    /**
     * Delete the dSExecutive by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete DSExecutive : {}", id);
        dSExecutiveRepository.deleteById(id);
    }
}
