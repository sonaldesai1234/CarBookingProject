package com.mycipl.web.rest;

import org.springframework.boot.test.context.SpringBootTest;

import com.mycipl.MyciplApp;

/**
 * Integration tests for the {@link DSExecutiveResource} REST controller.
 */
@SpringBootTest(classes = MyciplApp.class)
public class DSExecutiveResourceIT {/*

    @Autowired
    private DSExecutiveRepository dSExecutiveRepository;

    @Autowired
    private DSExecutiveService dSExecutiveService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private Validator validator;

    private MockMvc restDSExecutiveMockMvc;

    private DSExecutive dSExecutive;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final DSExecutiveResource dSExecutiveResource = new DSExecutiveResource(dSExecutiveService);
        this.restDSExecutiveMockMvc = MockMvcBuilders.standaloneSetup(dSExecutiveResource)
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
    public static DSExecutive createEntity() {
        DSExecutive dSExecutive = new DSExecutive();
        return dSExecutive;
    }
    *//**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     *//*
    public static DSExecutive createUpdatedEntity() {
        DSExecutive dSExecutive = new DSExecutive();
        return dSExecutive;
    }

    @BeforeEach
    public void initTest() {
        dSExecutiveRepository.deleteAll();
        dSExecutive = createEntity();
    }

    @Test
    public void createDSExecutive() throws Exception {
        int databaseSizeBeforeCreate = dSExecutiveRepository.findAll().size();

        // Create the DSExecutive
        restDSExecutiveMockMvc.perform(post("/api/ds-executives")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(dSExecutive)))
            .andExpect(status().isCreated());

        // Validate the DSExecutive in the database
        List<DSExecutive> dSExecutiveList = dSExecutiveRepository.findAll();
        assertThat(dSExecutiveList).hasSize(databaseSizeBeforeCreate + 1);
        DSExecutive testDSExecutive = dSExecutiveList.get(dSExecutiveList.size() - 1);
    }

    @Test
    public void createDSExecutiveWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = dSExecutiveRepository.findAll().size();

        // Create the DSExecutive with an existing ID
        dSExecutive.setId("existing_id");

        // An entity with an existing ID cannot be created, so this API call must fail
        restDSExecutiveMockMvc.perform(post("/api/ds-executives")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(dSExecutive)))
            .andExpect(status().isBadRequest());

        // Validate the DSExecutive in the database
        List<DSExecutive> dSExecutiveList = dSExecutiveRepository.findAll();
        assertThat(dSExecutiveList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    public void getAllDSExecutives() throws Exception {
        // Initialize the database
        dSExecutiveRepository.save(dSExecutive);

        // Get all the dSExecutiveList
        restDSExecutiveMockMvc.perform(get("/api/ds-executives?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(dSExecutive.getId())));
    }
    
    @Test
    public void getDSExecutive() throws Exception {
        // Initialize the database
        dSExecutiveRepository.save(dSExecutive);

        // Get the dSExecutive
        restDSExecutiveMockMvc.perform(get("/api/ds-executives/{id}", dSExecutive.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(dSExecutive.getId()));
    }

    @Test
    public void getNonExistingDSExecutive() throws Exception {
        // Get the dSExecutive
        restDSExecutiveMockMvc.perform(get("/api/ds-executives/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateDSExecutive() throws Exception {
        // Initialize the database
        dSExecutiveService.save(dSExecutive);

        int databaseSizeBeforeUpdate = dSExecutiveRepository.findAll().size();

        // Update the dSExecutive
        DSExecutive updatedDSExecutive = dSExecutiveRepository.findById(dSExecutive.getId()).get();

        restDSExecutiveMockMvc.perform(put("/api/ds-executives")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedDSExecutive)))
            .andExpect(status().isOk());

        // Validate the DSExecutive in the database
        List<DSExecutive> dSExecutiveList = dSExecutiveRepository.findAll();
        assertThat(dSExecutiveList).hasSize(databaseSizeBeforeUpdate);
        DSExecutive testDSExecutive = dSExecutiveList.get(dSExecutiveList.size() - 1);
    }

    @Test
    public void updateNonExistingDSExecutive() throws Exception {
        int databaseSizeBeforeUpdate = dSExecutiveRepository.findAll().size();

        // Create the DSExecutive

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDSExecutiveMockMvc.perform(put("/api/ds-executives")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(dSExecutive)))
            .andExpect(status().isBadRequest());

        // Validate the DSExecutive in the database
        List<DSExecutive> dSExecutiveList = dSExecutiveRepository.findAll();
        assertThat(dSExecutiveList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteDSExecutive() throws Exception {
        // Initialize the database
        dSExecutiveService.save(dSExecutive);

        int databaseSizeBeforeDelete = dSExecutiveRepository.findAll().size();

        // Delete the dSExecutive
        restDSExecutiveMockMvc.perform(delete("/api/ds-executives/{id}", dSExecutive.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<DSExecutive> dSExecutiveList = dSExecutiveRepository.findAll();
        assertThat(dSExecutiveList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DSExecutive.class);
        DSExecutive dSExecutive1 = new DSExecutive();
        dSExecutive1.setId("id1");
        DSExecutive dSExecutive2 = new DSExecutive();
        dSExecutive2.setId(dSExecutive1.getId());
        assertThat(dSExecutive1).isEqualTo(dSExecutive2);
        dSExecutive2.setId("id2");
        assertThat(dSExecutive1).isNotEqualTo(dSExecutive2);
        dSExecutive1.setId(null);
        assertThat(dSExecutive1).isNotEqualTo(dSExecutive2);
    }
*/}
