package com.mycipl.service.impl;

import com.mycipl.service.CarBookService;
import com.mycipl.domain.CarBook;
import com.mycipl.repository.CarBookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link CarBook}.
 */
@Service
public class CarBookServiceImpl implements CarBookService {

    private final Logger log = LoggerFactory.getLogger(CarBookServiceImpl.class);

    private final CarBookRepository carBookRepository;

    public CarBookServiceImpl(CarBookRepository carBookRepository) {
        this.carBookRepository = carBookRepository;
    }

    /**
     * Save a carBook.
     *
     * @param carBook the entity to save.
     * @return the persisted entity.
     */
    @Override
    public CarBook save(CarBook carBook) {
        log.debug("Request to save CarBook : {}", carBook);
        return carBookRepository.save(carBook);
    }

    /**
     * Get all the carBooks.
     *
     * @return the list of entities.
     */
    @Override
    public List<CarBook> findAll() {
        log.debug("Request to get all CarBooks");
        return carBookRepository.findAll();
    }


    /**
     * Get one carBook by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    public Optional<CarBook> findOne(String id) {
        log.debug("Request to get CarBook : {}", id);
        return carBookRepository.findById(id);
    }

    /**
     * Delete the carBook by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete CarBook : {}", id);
        carBookRepository.deleteById(id);
    }
}
