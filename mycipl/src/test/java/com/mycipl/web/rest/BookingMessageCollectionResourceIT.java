package com.mycipl.web.rest;

import org.springframework.boot.test.context.SpringBootTest;

import com.mycipl.MyciplApp;

/**
 * Integration tests for the {@link BookingMessageCollectionResource} REST controller.
 */
@SpringBootTest(classes = MyciplApp.class)
public class BookingMessageCollectionResourceIT {/*

    @Autowired
    private BookingMessageCollectionRepository bookingMessageCollectionRepository;

    @Autowired
    private BookingMessageCollectionService bookingMessageCollectionService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private Validator validator;

    private MockMvc restBookingMessageCollectionMockMvc;

    private BookingMessageCollection bookingMessageCollection;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final BookingMessageCollectionResource bookingMessageCollectionResource = new BookingMessageCollectionResource(bookingMessageCollectionService);
        this.restBookingMessageCollectionMockMvc = MockMvcBuilders.standaloneSetup(bookingMessageCollectionResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    *//**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     *//*
    public static BookingMessageCollection createEntity() {
        BookingMessageCollection bookingMessageCollection = new BookingMessageCollection();
        return bookingMessageCollection;
    }
    *//**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     *//*
    public static BookingMessageCollection createUpdatedEntity() {
        BookingMessageCollection bookingMessageCollection = new BookingMessageCollection();
        return bookingMessageCollection;
    }

    @BeforeEach
    public void initTest() {
        bookingMessageCollectionRepository.deleteAll();
        bookingMessageCollection = createEntity();
    }

    @Test
    public void createBookingMessageCollection() throws Exception {
        int databaseSizeBeforeCreate = bookingMessageCollectionRepository.findAll().size();

        // Create the BookingMessageCollection
        restBookingMessageCollectionMockMvc.perform(post("/api/booking-message-collections")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bookingMessageCollection)))
            .andExpect(status().isCreated());

        // Validate the BookingMessageCollection in the database
        List<BookingMessageCollection> bookingMessageCollectionList = bookingMessageCollectionRepository.findAll();
        assertThat(bookingMessageCollectionList).hasSize(databaseSizeBeforeCreate + 1);
        BookingMessageCollection testBookingMessageCollection = bookingMessageCollectionList.get(bookingMessageCollectionList.size() - 1);
    }

    @Test
    public void createBookingMessageCollectionWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = bookingMessageCollectionRepository.findAll().size();

        // Create the BookingMessageCollection with an existing ID
        bookingMessageCollection.setId("existing_id");

        // An entity with an existing ID cannot be created, so this API call must fail
        restBookingMessageCollectionMockMvc.perform(post("/api/booking-message-collections")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bookingMessageCollection)))
            .andExpect(status().isBadRequest());

        // Validate the BookingMessageCollection in the database
        List<BookingMessageCollection> bookingMessageCollectionList = bookingMessageCollectionRepository.findAll();
        assertThat(bookingMessageCollectionList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    public void getAllBookingMessageCollections() throws Exception {
        // Initialize the database
        bookingMessageCollectionRepository.save(bookingMessageCollection);

        // Get all the bookingMessageCollectionList
        restBookingMessageCollectionMockMvc.perform(get("/api/booking-message-collections?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(bookingMessageCollection.getId())));
    }
    
    @Test
    public void getBookingMessageCollection() throws Exception {
        // Initialize the database
        bookingMessageCollectionRepository.save(bookingMessageCollection);

        // Get the bookingMessageCollection
        restBookingMessageCollectionMockMvc.perform(get("/api/booking-message-collections/{id}", bookingMessageCollection.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(bookingMessageCollection.getId()));
    }

    @Test
    public void getNonExistingBookingMessageCollection() throws Exception {
        // Get the bookingMessageCollection
        restBookingMessageCollectionMockMvc.perform(get("/api/booking-message-collections/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateBookingMessageCollection() throws Exception {
        // Initialize the database
        bookingMessageCollectionService.save(bookingMessageCollection);

        int databaseSizeBeforeUpdate = bookingMessageCollectionRepository.findAll().size();

        // Update the bookingMessageCollection
        BookingMessageCollection updatedBookingMessageCollection = bookingMessageCollectionRepository.findById(bookingMessageCollection.getId()).get();

        restBookingMessageCollectionMockMvc.perform(put("/api/booking-message-collections")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedBookingMessageCollection)))
            .andExpect(status().isOk());

        // Validate the BookingMessageCollection in the database
        List<BookingMessageCollection> bookingMessageCollectionList = bookingMessageCollectionRepository.findAll();
        assertThat(bookingMessageCollectionList).hasSize(databaseSizeBeforeUpdate);
        BookingMessageCollection testBookingMessageCollection = bookingMessageCollectionList.get(bookingMessageCollectionList.size() - 1);
    }

    @Test
    public void updateNonExistingBookingMessageCollection() throws Exception {
        int databaseSizeBeforeUpdate = bookingMessageCollectionRepository.findAll().size();

        // Create the BookingMessageCollection

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBookingMessageCollectionMockMvc.perform(put("/api/booking-message-collections")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bookingMessageCollection)))
            .andExpect(status().isBadRequest());

        // Validate the BookingMessageCollection in the database
        List<BookingMessageCollection> bookingMessageCollectionList = bookingMessageCollectionRepository.findAll();
        assertThat(bookingMessageCollectionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteBookingMessageCollection() throws Exception {
        // Initialize the database
        bookingMessageCollectionService.save(bookingMessageCollection);

        int databaseSizeBeforeDelete = bookingMessageCollectionRepository.findAll().size();

        // Delete the bookingMessageCollection
        restBookingMessageCollectionMockMvc.perform(delete("/api/booking-message-collections/{id}", bookingMessageCollection.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<BookingMessageCollection> bookingMessageCollectionList = bookingMessageCollectionRepository.findAll();
        assertThat(bookingMessageCollectionList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BookingMessageCollection.class);
        BookingMessageCollection bookingMessageCollection1 = new BookingMessageCollection();
        bookingMessageCollection1.setId("id1");
        BookingMessageCollection bookingMessageCollection2 = new BookingMessageCollection();
        bookingMessageCollection2.setId(bookingMessageCollection1.getId());
        assertThat(bookingMessageCollection1).isEqualTo(bookingMessageCollection2);
        bookingMessageCollection2.setId("id2");
        assertThat(bookingMessageCollection1).isNotEqualTo(bookingMessageCollection2);
        bookingMessageCollection1.setId(null);
        assertThat(bookingMessageCollection1).isNotEqualTo(bookingMessageCollection2);
    }
*/}
