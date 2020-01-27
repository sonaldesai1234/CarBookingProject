package com.mycipl.web.rest;

import org.springframework.boot.test.context.SpringBootTest;

import com.mycipl.MyciplApp;

/**
 * Integration tests for the {@link OtpCollectionResource} REST controller.
 */
@SpringBootTest(classes = MyciplApp.class)
public class OtpCollectionResourceIT {/*

    @Autowired
    private OtpCollectionRepository otpCollectionRepository;

    @Autowired
    private OtpCollectionService otpCollectionService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private Validator validator;

    private MockMvc restOtpCollectionMockMvc;

    private OtpCollection otpCollection;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final OtpCollectionResource otpCollectionResource = new OtpCollectionResource(otpCollectionService);
        this.restOtpCollectionMockMvc = MockMvcBuilders.standaloneSetup(otpCollectionResource)
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
    public static OtpCollection createEntity() {
        OtpCollection otpCollection = new OtpCollection();
        return otpCollection;
    }
    *//**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     *//*
    public static OtpCollection createUpdatedEntity() {
        OtpCollection otpCollection = new OtpCollection();
        return otpCollection;
    }

    @BeforeEach
    public void initTest() {
        otpCollectionRepository.deleteAll();
        otpCollection = createEntity();
    }

    @Test
    public void createOtpCollection() throws Exception {
        int databaseSizeBeforeCreate = otpCollectionRepository.findAll().size();

        // Create the OtpCollection
        restOtpCollectionMockMvc.perform(post("/api/otp-collections")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(otpCollection)))
            .andExpect(status().isCreated());

        // Validate the OtpCollection in the database
        List<OtpCollection> otpCollectionList = otpCollectionRepository.findAll();
        assertThat(otpCollectionList).hasSize(databaseSizeBeforeCreate + 1);
        OtpCollection testOtpCollection = otpCollectionList.get(otpCollectionList.size() - 1);
    }

    @Test
    public void createOtpCollectionWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = otpCollectionRepository.findAll().size();

        // Create the OtpCollection with an existing ID
        otpCollection.setId("existing_id");

        // An entity with an existing ID cannot be created, so this API call must fail
        restOtpCollectionMockMvc.perform(post("/api/otp-collections")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(otpCollection)))
            .andExpect(status().isBadRequest());

        // Validate the OtpCollection in the database
        List<OtpCollection> otpCollectionList = otpCollectionRepository.findAll();
        assertThat(otpCollectionList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    public void getAllOtpCollections() throws Exception {
        // Initialize the database
        otpCollectionRepository.save(otpCollection);

        // Get all the otpCollectionList
        restOtpCollectionMockMvc.perform(get("/api/otp-collections?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(otpCollection.getId())));
    }
    
    @Test
    public void getOtpCollection() throws Exception {
        // Initialize the database
        otpCollectionRepository.save(otpCollection);

        // Get the otpCollection
        restOtpCollectionMockMvc.perform(get("/api/otp-collections/{id}", otpCollection.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(otpCollection.getId()));
    }

    @Test
    public void getNonExistingOtpCollection() throws Exception {
        // Get the otpCollection
        restOtpCollectionMockMvc.perform(get("/api/otp-collections/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateOtpCollection() throws Exception {
        // Initialize the database
        otpCollectionService.save(otpCollection);

        int databaseSizeBeforeUpdate = otpCollectionRepository.findAll().size();

        // Update the otpCollection
        OtpCollection updatedOtpCollection = otpCollectionRepository.findById(otpCollection.getId()).get();

        restOtpCollectionMockMvc.perform(put("/api/otp-collections")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedOtpCollection)))
            .andExpect(status().isOk());

        // Validate the OtpCollection in the database
        List<OtpCollection> otpCollectionList = otpCollectionRepository.findAll();
        assertThat(otpCollectionList).hasSize(databaseSizeBeforeUpdate);
        OtpCollection testOtpCollection = otpCollectionList.get(otpCollectionList.size() - 1);
    }

    @Test
    public void updateNonExistingOtpCollection() throws Exception {
        int databaseSizeBeforeUpdate = otpCollectionRepository.findAll().size();

        // Create the OtpCollection

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restOtpCollectionMockMvc.perform(put("/api/otp-collections")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(otpCollection)))
            .andExpect(status().isBadRequest());

        // Validate the OtpCollection in the database
        List<OtpCollection> otpCollectionList = otpCollectionRepository.findAll();
        assertThat(otpCollectionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteOtpCollection() throws Exception {
        // Initialize the database
        otpCollectionService.save(otpCollection);

        int databaseSizeBeforeDelete = otpCollectionRepository.findAll().size();

        // Delete the otpCollection
        restOtpCollectionMockMvc.perform(delete("/api/otp-collections/{id}", otpCollection.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<OtpCollection> otpCollectionList = otpCollectionRepository.findAll();
        assertThat(otpCollectionList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(OtpCollection.class);
        OtpCollection otpCollection1 = new OtpCollection();
        otpCollection1.setId("id1");
        OtpCollection otpCollection2 = new OtpCollection();
        otpCollection2.setId(otpCollection1.getId());
        assertThat(otpCollection1).isEqualTo(otpCollection2);
        otpCollection2.setId("id2");
        assertThat(otpCollection1).isNotEqualTo(otpCollection2);
        otpCollection1.setId(null);
        assertThat(otpCollection1).isNotEqualTo(otpCollection2);
    }
*/}
