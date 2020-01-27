package com.mycipl.web.rest;

import org.springframework.boot.test.context.SpringBootTest;

import com.mycipl.MyciplApp;

/**
 * Integration tests for the {@link NotificationCollectionResource} REST controller.
 */
@SpringBootTest(classes = MyciplApp.class)
public class NotificationCollectionResourceIT {/*

    @Autowired
    private NotificationCollectionRepository notificationCollectionRepository;

    @Autowired
    private NotificationCollectionService notificationCollectionService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private Validator validator;

    private MockMvc restNotificationCollectionMockMvc;

    private NotificationCollection notificationCollection;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final NotificationCollectionResource notificationCollectionResource = new NotificationCollectionResource(notificationCollectionService);
        this.restNotificationCollectionMockMvc = MockMvcBuilders.standaloneSetup(notificationCollectionResource)
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
    public static NotificationCollection createEntity() {
        NotificationCollection notificationCollection = new NotificationCollection();
        return notificationCollection;
    }
    *//**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     *//*
    public static NotificationCollection createUpdatedEntity() {
        NotificationCollection notificationCollection = new NotificationCollection();
        return notificationCollection;
    }

    @BeforeEach
    public void initTest() {
        notificationCollectionRepository.deleteAll();
        notificationCollection = createEntity();
    }

    @Test
    public void createNotificationCollection() throws Exception {
        int databaseSizeBeforeCreate = notificationCollectionRepository.findAll().size();

        // Create the NotificationCollection
        restNotificationCollectionMockMvc.perform(post("/api/notification-collections")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(notificationCollection)))
            .andExpect(status().isCreated());

        // Validate the NotificationCollection in the database
        List<NotificationCollection> notificationCollectionList = notificationCollectionRepository.findAll();
        assertThat(notificationCollectionList).hasSize(databaseSizeBeforeCreate + 1);
        NotificationCollection testNotificationCollection = notificationCollectionList.get(notificationCollectionList.size() - 1);
    }

    @Test
    public void createNotificationCollectionWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = notificationCollectionRepository.findAll().size();

        // Create the NotificationCollection with an existing ID
        notificationCollection.setId("existing_id");

        // An entity with an existing ID cannot be created, so this API call must fail
        restNotificationCollectionMockMvc.perform(post("/api/notification-collections")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(notificationCollection)))
            .andExpect(status().isBadRequest());

        // Validate the NotificationCollection in the database
        List<NotificationCollection> notificationCollectionList = notificationCollectionRepository.findAll();
        assertThat(notificationCollectionList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    public void getAllNotificationCollections() throws Exception {
        // Initialize the database
        notificationCollectionRepository.save(notificationCollection);

        // Get all the notificationCollectionList
        restNotificationCollectionMockMvc.perform(get("/api/notification-collections?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(notificationCollection.getId())));
    }
    
    @Test
    public void getNotificationCollection() throws Exception {
        // Initialize the database
        notificationCollectionRepository.save(notificationCollection);

        // Get the notificationCollection
        restNotificationCollectionMockMvc.perform(get("/api/notification-collections/{id}", notificationCollection.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(notificationCollection.getId()));
    }

    @Test
    public void getNonExistingNotificationCollection() throws Exception {
        // Get the notificationCollection
        restNotificationCollectionMockMvc.perform(get("/api/notification-collections/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateNotificationCollection() throws Exception {
        // Initialize the database
        notificationCollectionService.save(notificationCollection);

        int databaseSizeBeforeUpdate = notificationCollectionRepository.findAll().size();

        // Update the notificationCollection
        NotificationCollection updatedNotificationCollection = notificationCollectionRepository.findById(notificationCollection.getId()).get();

        restNotificationCollectionMockMvc.perform(put("/api/notification-collections")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedNotificationCollection)))
            .andExpect(status().isOk());

        // Validate the NotificationCollection in the database
        List<NotificationCollection> notificationCollectionList = notificationCollectionRepository.findAll();
        assertThat(notificationCollectionList).hasSize(databaseSizeBeforeUpdate);
        NotificationCollection testNotificationCollection = notificationCollectionList.get(notificationCollectionList.size() - 1);
    }

    @Test
    public void updateNonExistingNotificationCollection() throws Exception {
        int databaseSizeBeforeUpdate = notificationCollectionRepository.findAll().size();

        // Create the NotificationCollection

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restNotificationCollectionMockMvc.perform(put("/api/notification-collections")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(notificationCollection)))
            .andExpect(status().isBadRequest());

        // Validate the NotificationCollection in the database
        List<NotificationCollection> notificationCollectionList = notificationCollectionRepository.findAll();
        assertThat(notificationCollectionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteNotificationCollection() throws Exception {
        // Initialize the database
        notificationCollectionService.save(notificationCollection);

        int databaseSizeBeforeDelete = notificationCollectionRepository.findAll().size();

        // Delete the notificationCollection
        restNotificationCollectionMockMvc.perform(delete("/api/notification-collections/{id}", notificationCollection.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<NotificationCollection> notificationCollectionList = notificationCollectionRepository.findAll();
        assertThat(notificationCollectionList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(NotificationCollection.class);
        NotificationCollection notificationCollection1 = new NotificationCollection();
        notificationCollection1.setId("id1");
        NotificationCollection notificationCollection2 = new NotificationCollection();
        notificationCollection2.setId(notificationCollection1.getId());
        assertThat(notificationCollection1).isEqualTo(notificationCollection2);
        notificationCollection2.setId("id2");
        assertThat(notificationCollection1).isNotEqualTo(notificationCollection2);
        notificationCollection1.setId(null);
        assertThat(notificationCollection1).isNotEqualTo(notificationCollection2);
    }
*/}
