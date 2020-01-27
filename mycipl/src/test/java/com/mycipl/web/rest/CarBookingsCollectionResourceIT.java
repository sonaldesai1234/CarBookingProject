package com.mycipl.web.rest;

import org.springframework.boot.test.context.SpringBootTest;

import com.mycipl.MyciplApp;

/**
 * Integration tests for the {@link CarBookingsCollectionResource} REST controller.
 */
@SpringBootTest(classes = MyciplApp.class)
public class CarBookingsCollectionResourceIT {/*

    @Autowired
    private CarBookingsCollectionRepository carBookingsCollectionRepository;

    @Autowired
    private CarBookingsCollectionService carBookingsCollectionService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private Validator validator;

    private MockMvc restCarBookingsCollectionMockMvc;

    private CarBookingsCollection carBookingsCollection;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final CarBookingsCollectionResource carBookingsCollectionResource = new CarBookingsCollectionResource(carBookingsCollectionService);
        this.restCarBookingsCollectionMockMvc = MockMvcBuilders.standaloneSetup(carBookingsCollectionResource)
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
    public static CarBookingsCollection createEntity() {
        CarBookingsCollection carBookingsCollection = new CarBookingsCollection();
        return carBookingsCollection;
    }
    *//**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     *//*
    public static CarBookingsCollection createUpdatedEntity() {
        CarBookingsCollection carBookingsCollection = new CarBookingsCollection();
        return carBookingsCollection;
    }

    @BeforeEach
    public void initTest() {
        carBookingsCollectionRepository.deleteAll();
        carBookingsCollection = createEntity();
    }

    @Test
    public void createCarBookingsCollection() throws Exception {
        int databaseSizeBeforeCreate = carBookingsCollectionRepository.findAll().size();

        // Create the CarBookingsCollection
        restCarBookingsCollectionMockMvc.perform(post("/api/car-bookings-collections")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(carBookingsCollection)))
            .andExpect(status().isCreated());

        // Validate the CarBookingsCollection in the database
        List<CarBookingsCollection> carBookingsCollectionList = carBookingsCollectionRepository.findAll();
        assertThat(carBookingsCollectionList).hasSize(databaseSizeBeforeCreate + 1);
        CarBookingsCollection testCarBookingsCollection = carBookingsCollectionList.get(carBookingsCollectionList.size() - 1);
    }

    @Test
    public void createCarBookingsCollectionWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = carBookingsCollectionRepository.findAll().size();

        // Create the CarBookingsCollection with an existing ID
        carBookingsCollection.setId("existing_id");

        // An entity with an existing ID cannot be created, so this API call must fail
        restCarBookingsCollectionMockMvc.perform(post("/api/car-bookings-collections")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(carBookingsCollection)))
            .andExpect(status().isBadRequest());

        // Validate the CarBookingsCollection in the database
        List<CarBookingsCollection> carBookingsCollectionList = carBookingsCollectionRepository.findAll();
        assertThat(carBookingsCollectionList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    public void getAllCarBookingsCollections() throws Exception {
        // Initialize the database
        carBookingsCollectionRepository.save(carBookingsCollection);

        // Get all the carBookingsCollectionList
        restCarBookingsCollectionMockMvc.perform(get("/api/car-bookings-collections?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(carBookingsCollection.getId())));
    }
    
    @Test
    public void getCarBookingsCollection() throws Exception {
        // Initialize the database
        carBookingsCollectionRepository.save(carBookingsCollection);

        // Get the carBookingsCollection
        restCarBookingsCollectionMockMvc.perform(get("/api/car-bookings-collections/{id}", carBookingsCollection.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(carBookingsCollection.getId()));
    }

    @Test
    public void getNonExistingCarBookingsCollection() throws Exception {
        // Get the carBookingsCollection
        restCarBookingsCollectionMockMvc.perform(get("/api/car-bookings-collections/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateCarBookingsCollection() throws Exception {
        // Initialize the database
        carBookingsCollectionService.save(carBookingsCollection);

        int databaseSizeBeforeUpdate = carBookingsCollectionRepository.findAll().size();

        // Update the carBookingsCollection
        CarBookingsCollection updatedCarBookingsCollection = carBookingsCollectionRepository.findById(carBookingsCollection.getId()).get();

        restCarBookingsCollectionMockMvc.perform(put("/api/car-bookings-collections")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedCarBookingsCollection)))
            .andExpect(status().isOk());

        // Validate the CarBookingsCollection in the database
        List<CarBookingsCollection> carBookingsCollectionList = carBookingsCollectionRepository.findAll();
        assertThat(carBookingsCollectionList).hasSize(databaseSizeBeforeUpdate);
        CarBookingsCollection testCarBookingsCollection = carBookingsCollectionList.get(carBookingsCollectionList.size() - 1);
    }

    @Test
    public void updateNonExistingCarBookingsCollection() throws Exception {
        int databaseSizeBeforeUpdate = carBookingsCollectionRepository.findAll().size();

        // Create the CarBookingsCollection

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCarBookingsCollectionMockMvc.perform(put("/api/car-bookings-collections")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(carBookingsCollection)))
            .andExpect(status().isBadRequest());

        // Validate the CarBookingsCollection in the database
        List<CarBookingsCollection> carBookingsCollectionList = carBookingsCollectionRepository.findAll();
        assertThat(carBookingsCollectionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteCarBookingsCollection() throws Exception {
        // Initialize the database
        carBookingsCollectionService.save(carBookingsCollection);

        int databaseSizeBeforeDelete = carBookingsCollectionRepository.findAll().size();

        // Delete the carBookingsCollection
        restCarBookingsCollectionMockMvc.perform(delete("/api/car-bookings-collections/{id}", carBookingsCollection.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<CarBookingsCollection> carBookingsCollectionList = carBookingsCollectionRepository.findAll();
        assertThat(carBookingsCollectionList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CarBookingsCollection.class);
        CarBookingsCollection carBookingsCollection1 = new CarBookingsCollection();
        carBookingsCollection1.setId("id1");
        CarBookingsCollection carBookingsCollection2 = new CarBookingsCollection();
        carBookingsCollection2.setId(carBookingsCollection1.getId());
        assertThat(carBookingsCollection1).isEqualTo(carBookingsCollection2);
        carBookingsCollection2.setId("id2");
        assertThat(carBookingsCollection1).isNotEqualTo(carBookingsCollection2);
        carBookingsCollection1.setId(null);
        assertThat(carBookingsCollection1).isNotEqualTo(carBookingsCollection2);
    }
*/}
