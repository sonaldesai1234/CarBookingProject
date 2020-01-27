package com.mycipl.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycipl.domain.CarBook;
import com.mycipl.service.CarBookService;
import com.mycipl.web.rest.errors.BadRequestAlertException;
import com.mycipl.web.rest.util.HeaderUtil;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycipl.domain.CarBook}.
 */
@RestController
@RequestMapping("/api")
public class CarBookResource {

    private final Logger log = LoggerFactory.getLogger(CarBookResource.class);

    private static final String ENTITY_NAME = "carBook";


    private final CarBookService carBookService;

    public CarBookResource(CarBookService carBookService) {
        this.carBookService = carBookService;
    }

    /**
     * {@code POST  /car-books} : Create a new carBook.
     *
     * @param carBook the carBook to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new carBook, or with status {@code 400 (Bad Request)} if the carBook has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/car-books")
    public ResponseEntity<CarBook> createCarBook(@RequestBody CarBook carBook) throws URISyntaxException {
        log.debug("REST request to save CarBook : {}", carBook);
        
        if (carBook.getId() != null) {
            throw new BadRequestAlertException("A new carBook cannot already have an ID", ENTITY_NAME, "idexists");
        }
        
        CarBook result = carBookService.save(carBook);
        return ResponseEntity.created(new URI("/api/car-books/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("", true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /car-books} : Updates an existing carBook.
     *
     * @param carBook the carBook to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated carBook,
     * or with status {@code 400 (Bad Request)} if the carBook is not valid,
     * or with status {@code 500 (Internal Server Error)} if the carBook couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/car-books")
    public ResponseEntity<CarBook> updateCarBook(@RequestBody CarBook carBook) throws URISyntaxException {
        log.debug("REST request to update CarBook : {}", carBook);
        if (carBook.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CarBook result = carBookService.save(carBook);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("", true, ENTITY_NAME, carBook.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /car-books} : get all the carBooks.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of carBooks in body.
     */
    @GetMapping("/car-books")
    public List<CarBook> getAllCarBooks() {
        log.debug("REST request to get all CarBooks");
        return carBookService.findAll();
    }

    /**
     * {@code GET  /car-books/:id} : get the "id" carBook.
     *
     * @param id the id of the carBook to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the carBook, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/car-books/{id}")
    public ResponseEntity<CarBook> getCarBook(@PathVariable String id) {
        log.debug("REST request to get CarBook : {}", id);
        Optional<CarBook> carBook = carBookService.findOne(id);
        return ResponseUtil.wrapOrNotFound(carBook);
    }

    /**
     * {@code DELETE  /car-books/:id} : delete the "id" carBook.
     *
     * @param id the id of the carBook to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/car-books/{id}")
    public ResponseEntity<Void> deleteCarBook(@PathVariable String id) {
        log.debug("REST request to delete CarBook : {}", id);
        carBookService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert("", true, ENTITY_NAME, id)).build();
    }
    
    
    
}
