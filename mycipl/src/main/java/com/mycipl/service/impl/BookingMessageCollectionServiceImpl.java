package com.mycipl.service.impl;

import com.mycipl.service.BookingMessageCollectionService;
import com.mycipl.domain.BookingMessageCollection;
import com.mycipl.repository.BookingMessageCollectionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link BookingMessageCollection}.
 */
@Service
public class BookingMessageCollectionServiceImpl implements BookingMessageCollectionService {

    private final Logger log = LoggerFactory.getLogger(BookingMessageCollectionServiceImpl.class);

    private final BookingMessageCollectionRepository bookingMessageCollectionRepository;

    public BookingMessageCollectionServiceImpl(BookingMessageCollectionRepository bookingMessageCollectionRepository) {
        this.bookingMessageCollectionRepository = bookingMessageCollectionRepository;
    }

    /**
     * Save a bookingMessageCollection.
     *
     * @param bookingMessageCollection the entity to save.
     * @return the persisted entity.
     */
    @Override
    public BookingMessageCollection save(BookingMessageCollection bookingMessageCollection) {
        log.debug("Request to save BookingMessageCollection : {}", bookingMessageCollection);
        return bookingMessageCollectionRepository.save(bookingMessageCollection);
    }

    /**
     * Get all the bookingMessageCollections.
     *
     * @return the list of entities.
     */
    @Override
    public List<BookingMessageCollection> findAll() {
        log.debug("Request to get all BookingMessageCollections");
        return bookingMessageCollectionRepository.findAll();
    }


    /**
     * Get one bookingMessageCollection by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    

    /**
     * Delete the bookingMessageCollection by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete BookingMessageCollection : {}", id);
        bookingMessageCollectionRepository.deleteById(id);
    }

	@Override
	public List<BookingMessageCollection> findOneById(String id) {
		// TODO Auto-generated method stub
		return bookingMessageCollectionRepository.findOneById(id);
	}
}
