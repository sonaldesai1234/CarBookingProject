package com.mycipl.web.rest;

import org.springframework.boot.test.context.SpringBootTest;

import com.mycipl.MyciplApp;

/**
 * Integration tests for the {@link NotificationSchedulerCollectionResource} REST controller.
 */
@SpringBootTest(classes = MyciplApp.class)
public class NotificationSchedulerCollectionResourceIT {/*

    @Autowired
    private NotificationSchedulerCollectionRepository notificationSchedulerCollectionRepository;

    @Autowired
    private NotificationSchedulerCollectionService notificationSchedulerCollectionService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private Validator validator;

    private MockMvc restNotificationSchedulerCollectionMockMvc;

    private NotificationSchedulerCollection notificationSchedulerCollection;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final NotificationSchedulerCollectionResource notificationSchedulerCollectionResource = new NotificationSchedulerCollectionResource(notificationSchedulerCollectionService);
        this.restNotificationSchedulerCollectionMockMvc = MockMvcBuilders.standaloneSetup(notificationSchedulerCollectionResource)
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
    public static NotificationSchedulerCollection createEntity() {
        NotificationSchedulerCollection notificationSchedulerCollection = new NotificationSchedulerCollection();
        return notificationSchedulerCollection;
    }
    *//**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     *//*
    public static NotificationSchedulerCollection createUpdatedEntity() {
        NotificationSchedulerCollection notificationSchedulerCollection = new NotificationSchedulerCollection();
        return notificationSchedulerCollection;
    }

    @BeforeEach
    public void initTest() {
        notificationSchedulerCollectionRepository.deleteAll();
        notificationSchedulerCollection = createEntity();
    }

    @Test
    public void createNotificationSchedulerCollection() throws Exception {
        int databaseSizeBeforeCreate = notificationSchedulerCollectionRepository.findAll().size();

        // Create the NotificationSchedulerCollection
        restNotificationSchedulerCollectionMockMvc.perform(post("/api/notification-scheduler-collections")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(notificationSchedulerCollection)))
            .andExpect(status().isCreated());

        // Validate the NotificationSchedulerCollection in the database
        List<NotificationSchedulerCollection> notificationSchedulerCollectionList = notificationSchedulerCollectionRepository.findAll();
        assertThat(notificationSchedulerCollectionList).hasSize(databaseSizeBeforeCreate + 1);
        NotificationSchedulerCollection testNotificationSchedulerCollection = notificationSchedulerCollectionList.get(notificationSchedulerCollectionList.size() - 1);
    }

    @Test
    public void createNotificationSchedulerCollectionWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = notificationSchedulerCollectionRepository.findAll().size();

        // Create the NotificationSchedulerCollection with an existing ID
        notificationSchedulerCollection.setId("existing_id");

        // An entity with an existing ID cannot be created, so this API call must fail
        restNotificationSchedulerCollectionMockMvc.perform(post("/api/notification-scheduler-collections")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(notificationSchedulerCollection)))
            .andExpect(status().isBadRequest());

        // Validate the NotificationSchedulerCollection in the database
        List<NotificationSchedulerCollection> notificationSchedulerCollectionList = notificationSchedulerCollectionRepository.findAll();
        assertThat(notificationSchedulerCollectionList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    public void getAllNotificationSchedulerCollections() throws Exception {
        // Initialize the database
        notificationSchedulerCollectionRepository.save(notificationSchedulerCollection);

        // Get all the notificationSchedulerCollectionList
        restNotificationSchedulerCollectionMockMvc.perform(get("/api/notification-scheduler-collections?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(notificationSchedulerCollection.getId())));
    }
    
    @Test
    public void getNotificationSchedulerCollection() throws Exception {
        // Initialize the database
        notificationSchedulerCollectionRepository.save(notificationSchedulerCollection);

        // Get the notificationSchedulerCollection
        restNotificationSchedulerCollectionMockMvc.perform(get("/api/notification-scheduler-collections/{id}", notificationSchedulerCollection.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(notificationSchedulerCollection.getId()));
    }

    @Test
    public void getNonExistingNotificationSchedulerCollection() throws Exception {
        // Get the notificationSchedulerCollection
        restNotificationSchedulerCollectionMockMvc.perform(get("/api/notification-scheduler-collections/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateNotificationSchedulerCollection() throws Exception {
        // Initialize the database
        notificationSchedulerCollectionService.save(notificationSchedulerCollection);

        int databaseSizeBeforeUpdate = notificationSchedulerCollectionRepository.findAll().size();

        // Update the notificationSchedulerCollection
        NotificationSchedulerCollection updatedNotificationSchedulerCollection = notificationSchedulerCollectionRepository.findById(notificationSchedulerCollection.getId()).get();

        restNotificationSchedulerCollectionMockMvc.perform(put("/api/notification-scheduler-collections")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedNotificationSchedulerCollection)))
            .andExpect(status().isOk());

        // Validate the NotificationSchedulerCollection in the database
        List<NotificationSchedulerCollection> notificationSchedulerCollectionList = notificationSchedulerCollectionRepository.findAll();
        assertThat(notificationSchedulerCollectionList).hasSize(databaseSizeBeforeUpdate);
        NotificationSchedulerCollection testNotificationSchedulerCollection = notificationSchedulerCollectionList.get(notificationSchedulerCollectionList.size() - 1);
    }

    @Test
    public void updateNonExistingNotificationSchedulerCollection() throws Exception {
        int databaseSizeBeforeUpdate = notificationSchedulerCollectionRepository.findAll().size();

        // Create the NotificationSchedulerCollection

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restNotificationSchedulerCollectionMockMvc.perform(put("/api/notification-scheduler-collections")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(notificationSchedulerCollection)))
            .andExpect(status().isBadRequest());

        // Validate the NotificationSchedulerCollection in the database
        List<NotificationSchedulerCollection> notificationSchedulerCollectionList = notificationSchedulerCollectionRepository.findAll();
        assertThat(notificationSchedulerCollectionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteNotificationSchedulerCollection() throws Exception {
        // Initialize the database
        notificationSchedulerCollectionService.save(notificationSchedulerCollection);

        int databaseSizeBeforeDelete = notificationSchedulerCollectionRepository.findAll().size();

        // Delete the notificationSchedulerCollection
        restNotificationSchedulerCollectionMockMvc.perform(delete("/api/notification-scheduler-collections/{id}", notificationSchedulerCollection.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<NotificationSchedulerCollection> notificationSchedulerCollectionList = notificationSchedulerCollectionRepository.findAll();
        assertThat(notificationSchedulerCollectionList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(NotificationSchedulerCollection.class);
        NotificationSchedulerCollection notificationSchedulerCollection1 = new NotificationSchedulerCollection();
        notificationSchedulerCollection1.setId("id1");
        NotificationSchedulerCollection notificationSchedulerCollection2 = new NotificationSchedulerCollection();
        notificationSchedulerCollection2.setId(notificationSchedulerCollection1.getId());
        assertThat(notificationSchedulerCollection1).isEqualTo(notificationSchedulerCollection2);
        notificationSchedulerCollection2.setId("id2");
        assertThat(notificationSchedulerCollection1).isNotEqualTo(notificationSchedulerCollection2);
        notificationSchedulerCollection1.setId(null);
        assertThat(notificationSchedulerCollection1).isNotEqualTo(notificationSchedulerCollection2);
    }
*/}
