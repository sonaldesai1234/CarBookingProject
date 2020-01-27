package com.mycipl.web.rest;

import org.springframework.boot.test.context.SpringBootTest;

import com.mycipl.MyciplApp;

/**
 * Integration tests for the {@link CarBookResource} REST controller.
 */
@SpringBootTest(classes = MyciplApp.class)
public class CarBookResourceIT {/*

    @Autowired
    private CarBookRepository carBookRepository;

    @Autowired
    private CarBookService carBookService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private Validator validator;

    private MockMvc restCarBookMockMvc;

    private CarBook carBook;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final CarBookResource carBookResource = new CarBookResource(carBookService);
        this.restCarBookMockMvc = MockMvcBuilders.standaloneSetup(carBookResource)
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
    public static CarBook createEntity() {
        CarBook carBook = new CarBook();
        return carBook;
    }
    *//**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     *//*
    public static CarBook createUpdatedEntity() {
        CarBook carBook = new CarBook();
        return carBook;
    }

    @BeforeEach
    public void initTest() {
        carBookRepository.deleteAll();
        carBook = createEntity();
    }

    @Test
    public void createCarBook() throws Exception {
        int databaseSizeBeforeCreate = carBookRepository.findAll().size();

        // Create the CarBook
        restCarBookMockMvc.perform(post("/api/car-books")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(carBook)))
            .andExpect(status().isCreated());

        // Validate the CarBook in the database
        List<CarBook> carBookList = carBookRepository.findAll();
        assertThat(carBookList).hasSize(databaseSizeBeforeCreate + 1);
        CarBook testCarBook = carBookList.get(carBookList.size() - 1);
    }

    @Test
    public void createCarBookWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = carBookRepository.findAll().size();

        // Create the CarBook with an existing ID
        carBook.setId("existing_id");

        // An entity with an existing ID cannot be created, so this API call must fail
        restCarBookMockMvc.perform(post("/api/car-books")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(carBook)))
            .andExpect(status().isBadRequest());

        // Validate the CarBook in the database
        List<CarBook> carBookList = carBookRepository.findAll();
        assertThat(carBookList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    public void getAllCarBooks() throws Exception {
        // Initialize the database
        carBookRepository.save(carBook);

        // Get all the carBookList
        restCarBookMockMvc.perform(get("/api/car-books?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(carBook.getId())));
    }
    
    @Test
    public void getCarBook() throws Exception {
        // Initialize the database
        carBookRepository.save(carBook);

        // Get the carBook
        restCarBookMockMvc.perform(get("/api/car-books/{id}", carBook.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(carBook.getId()));
    }

    @Test
    public void getNonExistingCarBook() throws Exception {
        // Get the carBook
        restCarBookMockMvc.perform(get("/api/car-books/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateCarBook() throws Exception {
        // Initialize the database
        carBookService.save(carBook);

        int databaseSizeBeforeUpdate = carBookRepository.findAll().size();

        // Update the carBook
        CarBook updatedCarBook = carBookRepository.findById(carBook.getId()).get();

        restCarBookMockMvc.perform(put("/api/car-books")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedCarBook)))
            .andExpect(status().isOk());

        // Validate the CarBook in the database
        List<CarBook> carBookList = carBookRepository.findAll();
        assertThat(carBookList).hasSize(databaseSizeBeforeUpdate);
        CarBook testCarBook = carBookList.get(carBookList.size() - 1);
    }

    @Test
    public void updateNonExistingCarBook() throws Exception {
        int databaseSizeBeforeUpdate = carBookRepository.findAll().size();

        // Create the CarBook

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCarBookMockMvc.perform(put("/api/car-books")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(carBook)))
            .andExpect(status().isBadRequest());

        // Validate the CarBook in the database
        List<CarBook> carBookList = carBookRepository.findAll();
        assertThat(carBookList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteCarBook() throws Exception {
        // Initialize the database
        carBookService.save(carBook);

        int databaseSizeBeforeDelete = carBookRepository.findAll().size();

        // Delete the carBook
        restCarBookMockMvc.perform(delete("/api/car-books/{id}", carBook.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<CarBook> carBookList = carBookRepository.findAll();
        assertThat(carBookList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CarBook.class);
        CarBook carBook1 = new CarBook();
        carBook1.setId("id1");
        CarBook carBook2 = new CarBook();
        carBook2.setId(carBook1.getId());
        assertThat(carBook1).isEqualTo(carBook2);
        carBook2.setId("id2");
        assertThat(carBook1).isNotEqualTo(carBook2);
        carBook1.setId(null);
        assertThat(carBook1).isNotEqualTo(carBook2);
    }
*/}
