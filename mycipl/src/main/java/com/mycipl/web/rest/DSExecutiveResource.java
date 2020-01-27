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

import com.mycipl.domain.DSExecutive;
import com.mycipl.service.DSExecutiveService;
import com.mycipl.web.rest.errors.BadRequestAlertException;
import com.mycipl.web.rest.util.HeaderUtil;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycipl.domain.DSExecutive}.
 */
@RestController
@RequestMapping("/api")
public class DSExecutiveResource {

    private final Logger log = LoggerFactory.getLogger(DSExecutiveResource.class);

    private static final String ENTITY_NAME = "dSExecutive";


    private final DSExecutiveService dSExecutiveService;

    public DSExecutiveResource(DSExecutiveService dSExecutiveService) {
        this.dSExecutiveService = dSExecutiveService;
    }

    /**
     * {@code POST  /ds-executives} : Create a new dSExecutive.
     *
     * @param dSExecutive the dSExecutive to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new dSExecutive, or with status {@code 400 (Bad Request)} if the dSExecutive has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ds-executives")
    public ResponseEntity<DSExecutive> createDSExecutive(@RequestBody DSExecutive dSExecutive) throws URISyntaxException {
        log.debug("REST request to save DSExecutive : {}", dSExecutive);
        if (dSExecutive.getId() != null) {
            throw new BadRequestAlertException("A new dSExecutive cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DSExecutive result = dSExecutiveService.save(dSExecutive);
        return ResponseEntity.created(new URI("/api/ds-executives/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("", true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /ds-executives} : Updates an existing dSExecutive.
     *
     * @param dSExecutive the dSExecutive to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dSExecutive,
     * or with status {@code 400 (Bad Request)} if the dSExecutive is not valid,
     * or with status {@code 500 (Internal Server Error)} if the dSExecutive couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/ds-executives")
    public ResponseEntity<DSExecutive> updateDSExecutive(@RequestBody DSExecutive dSExecutive) throws URISyntaxException {
        log.debug("REST request to update DSExecutive : {}", dSExecutive);
        if (dSExecutive.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DSExecutive result = dSExecutiveService.save(dSExecutive);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("", true, ENTITY_NAME, dSExecutive.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /ds-executives} : get all the dSExecutives.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of dSExecutives in body.
     */
    @GetMapping("/ds-executives")
    public List<DSExecutive> getAllDSExecutives() {
        log.debug("REST request to get all DSExecutives");
        return dSExecutiveService.findAll();
    }

    /**
     * {@code GET  /ds-executives/:id} : get the "id" dSExecutive.
     *
     * @param id the id of the dSExecutive to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the dSExecutive, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ds-executives/{id}")
    public ResponseEntity<DSExecutive> getDSExecutive(@PathVariable String id) {
        log.debug("REST request to get DSExecutive : {}", id);
        Optional<DSExecutive> dSExecutive = dSExecutiveService.findOne(id);
        return ResponseUtil.wrapOrNotFound(dSExecutive);
    }

    /**
     * {@code DELETE  /ds-executives/:id} : delete the "id" dSExecutive.
     *
     * @param id the id of the dSExecutive to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/ds-executives/{id}")
    public ResponseEntity<Void> deleteDSExecutive(@PathVariable String id) {
        log.debug("REST request to delete DSExecutive : {}", id);
        dSExecutiveService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert("", true, ENTITY_NAME, id)).build();
    }
}
