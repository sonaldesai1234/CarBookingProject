package com.mycipl.web.rest;

import org.springframework.boot.test.context.SpringBootTest;

import com.mycipl.MyciplApp;

/**
 * Integration tests for the {@link AndroidVersionForceUpdateResource} REST controller.
 */
@SpringBootTest(classes = MyciplApp.class)
public class AndroidVersionForceUpdateResourceIT {/*

    @Autowired
    private AndroidVersionForceUpdateRepository androidVersionForceUpdateRepository;

    @Autowired
    private AndroidVersionForceUpdateService androidVersionForceUpdateService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private Validator validator;

    private MockMvc restAndroidVersionForceUpdateMockMvc;

    private AndroidVersionForceUpdate androidVersionForceUpdate;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final AndroidVersionForceUpdateResource androidVersionForceUpdateResource = new AndroidVersionForceUpdateResource(androidVersionForceUpdateService);
        this.restAndroidVersionForceUpdateMockMvc = MockMvcBuilders.standaloneSetup(androidVersionForceUpdateResource)
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
    public static AndroidVersionForceUpdate createEntity() {
        AndroidVersionForceUpdate androidVersionForceUpdate = new AndroidVersionForceUpdate();
        return androidVersionForceUpdate;
    }
    *//**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     *//*
    public static AndroidVersionForceUpdate createUpdatedEntity() {
        AndroidVersionForceUpdate androidVersionForceUpdate = new AndroidVersionForceUpdate();
        return androidVersionForceUpdate;
    }

    @BeforeEach
    public void initTest() {
        androidVersionForceUpdateRepository.deleteAll();
        androidVersionForceUpdate = createEntity();
    }

    @Test
    public void createAndroidVersionForceUpdate() throws Exception {
        int databaseSizeBeforeCreate = androidVersionForceUpdateRepository.findAll().size();

        // Create the AndroidVersionForceUpdate
        restAndroidVersionForceUpdateMockMvc.perform(post("/api/android-version-force-updates")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(androidVersionForceUpdate)))
            .andExpect(status().isCreated());

        // Validate the AndroidVersionForceUpdate in the database
        List<AndroidVersionForceUpdate> androidVersionForceUpdateList = androidVersionForceUpdateRepository.findAll();
        assertThat(androidVersionForceUpdateList).hasSize(databaseSizeBeforeCreate + 1);
        AndroidVersionForceUpdate testAndroidVersionForceUpdate = androidVersionForceUpdateList.get(androidVersionForceUpdateList.size() - 1);
    }

    @Test
    public void createAndroidVersionForceUpdateWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = androidVersionForceUpdateRepository.findAll().size();

        // Create the AndroidVersionForceUpdate with an existing ID
        androidVersionForceUpdate.setId("existing_id");

        // An entity with an existing ID cannot be created, so this API call must fail
        restAndroidVersionForceUpdateMockMvc.perform(post("/api/android-version-force-updates")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(androidVersionForceUpdate)))
            .andExpect(status().isBadRequest());

        // Validate the AndroidVersionForceUpdate in the database
        List<AndroidVersionForceUpdate> androidVersionForceUpdateList = androidVersionForceUpdateRepository.findAll();
        assertThat(androidVersionForceUpdateList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    public void getAllAndroidVersionForceUpdates() throws Exception {
        // Initialize the database
        androidVersionForceUpdateRepository.save(androidVersionForceUpdate);

        // Get all the androidVersionForceUpdateList
        restAndroidVersionForceUpdateMockMvc.perform(get("/api/android-version-force-updates?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(androidVersionForceUpdate.getId())));
    }
    
    @Test
    public void getAndroidVersionForceUpdate() throws Exception {
        // Initialize the database
        androidVersionForceUpdateRepository.save(androidVersionForceUpdate);

        // Get the androidVersionForceUpdate
        restAndroidVersionForceUpdateMockMvc.perform(get("/api/android-version-force-updates/{id}", androidVersionForceUpdate.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(androidVersionForceUpdate.getId()));
    }

    @Test
    public void getNonExistingAndroidVersionForceUpdate() throws Exception {
        // Get the androidVersionForceUpdate
        restAndroidVersionForceUpdateMockMvc.perform(get("/api/android-version-force-updates/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateAndroidVersionForceUpdate() throws Exception {
        // Initialize the database
        androidVersionForceUpdateService.save(androidVersionForceUpdate);

        int databaseSizeBeforeUpdate = androidVersionForceUpdateRepository.findAll().size();

        // Update the androidVersionForceUpdate
        AndroidVersionForceUpdate updatedAndroidVersionForceUpdate = androidVersionForceUpdateRepository.findById(androidVersionForceUpdate.getId()).get();

        restAndroidVersionForceUpdateMockMvc.perform(put("/api/android-version-force-updates")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedAndroidVersionForceUpdate)))
            .andExpect(status().isOk());

        // Validate the AndroidVersionForceUpdate in the database
        List<AndroidVersionForceUpdate> androidVersionForceUpdateList = androidVersionForceUpdateRepository.findAll();
        assertThat(androidVersionForceUpdateList).hasSize(databaseSizeBeforeUpdate);
        AndroidVersionForceUpdate testAndroidVersionForceUpdate = androidVersionForceUpdateList.get(androidVersionForceUpdateList.size() - 1);
    }

    @Test
    public void updateNonExistingAndroidVersionForceUpdate() throws Exception {
        int databaseSizeBeforeUpdate = androidVersionForceUpdateRepository.findAll().size();

        // Create the AndroidVersionForceUpdate

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAndroidVersionForceUpdateMockMvc.perform(put("/api/android-version-force-updates")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(androidVersionForceUpdate)))
            .andExpect(status().isBadRequest());

        // Validate the AndroidVersionForceUpdate in the database
        List<AndroidVersionForceUpdate> androidVersionForceUpdateList = androidVersionForceUpdateRepository.findAll();
        assertThat(androidVersionForceUpdateList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteAndroidVersionForceUpdate() throws Exception {
        // Initialize the database
        androidVersionForceUpdateService.save(androidVersionForceUpdate);

        int databaseSizeBeforeDelete = androidVersionForceUpdateRepository.findAll().size();

        // Delete the androidVersionForceUpdate
        restAndroidVersionForceUpdateMockMvc.perform(delete("/api/android-version-force-updates/{id}", androidVersionForceUpdate.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<AndroidVersionForceUpdate> androidVersionForceUpdateList = androidVersionForceUpdateRepository.findAll();
        assertThat(androidVersionForceUpdateList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AndroidVersionForceUpdate.class);
        AndroidVersionForceUpdate androidVersionForceUpdate1 = new AndroidVersionForceUpdate();
        androidVersionForceUpdate1.setId("id1");
        AndroidVersionForceUpdate androidVersionForceUpdate2 = new AndroidVersionForceUpdate();
        androidVersionForceUpdate2.setId(androidVersionForceUpdate1.getId());
        assertThat(androidVersionForceUpdate1).isEqualTo(androidVersionForceUpdate2);
        androidVersionForceUpdate2.setId("id2");
        assertThat(androidVersionForceUpdate1).isNotEqualTo(androidVersionForceUpdate2);
        androidVersionForceUpdate1.setId(null);
        assertThat(androidVersionForceUpdate1).isNotEqualTo(androidVersionForceUpdate2);
    }
*/}
