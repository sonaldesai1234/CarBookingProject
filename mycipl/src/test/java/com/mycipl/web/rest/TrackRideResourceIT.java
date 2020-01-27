/*
 * package com.mycipl.web.rest;
 * 
 * import com.mycipl.MyciplApp; import com.mycipl.domain.TrackRide; import
 * com.mycipl.repository.TrackRideRepository; import
 * com.mycipl.service.TrackRideService; import
 * com.mycipl.web.rest.errors.ExceptionTranslator;
 * 
 * import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;
 * import org.mockito.MockitoAnnotations; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.data.web.PageableHandlerMethodArgumentResolver; import
 * org.springframework.http.MediaType; import
 * org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
 * import org.springframework.test.web.servlet.MockMvc; import
 * org.springframework.test.web.servlet.setup.MockMvcBuilders; import
 * org.springframework.validation.Validator;
 * 
 * 
 * import java.util.List;
 * 
 * import static com.mycipl.web.rest.TestUtil.createFormattingConversionService;
 * import static org.assertj.core.api.Assertions.assertThat; import static
 * org.hamcrest.Matchers.hasItem; import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; import
 * static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
 * 
 *//**
	 * Integration tests for the {@link TrackRideResource} REST controller.
	 */
/*
 * @SpringBootTest(classes = MyciplApp.class) public class TrackRideResourceIT {
 * 
 * @Autowired private TrackRideRepository trackRideRepository;
 * 
 * @Autowired private TrackRideService trackRideService;
 * 
 * @Autowired private MappingJackson2HttpMessageConverter
 * jacksonMessageConverter;
 * 
 * @Autowired private PageableHandlerMethodArgumentResolver
 * pageableArgumentResolver;
 * 
 * @Autowired private ExceptionTranslator exceptionTranslator;
 * 
 * @Autowired private Validator validator;
 * 
 * private MockMvc restTrackRideMockMvc;
 * 
 * private TrackRide trackRide;
 * 
 * @BeforeEach public void setup() { MockitoAnnotations.initMocks(this); final
 * TrackRideResource trackRideResource = new
 * TrackRideResource(trackRideService); this.restTrackRideMockMvc =
 * MockMvcBuilders.standaloneSetup(trackRideResource)
 * .setCustomArgumentResolvers(pageableArgumentResolver)
 * .setControllerAdvice(exceptionTranslator)
 * .setConversionService(createFormattingConversionService())
 * .setMessageConverters(jacksonMessageConverter)
 * .setValidator(validator).build(); }
 * 
 *//**
	 * Create an entity for this test.
	 *
	 * This is a static method, as tests for other entities might also need it, if
	 * they test an entity which requires the current entity.
	 */
/*
 * public static TrackRide createEntity() { TrackRide trackRide = new
 * TrackRide(); return trackRide; }
 *//**
	 * Create an updated entity for this test.
	 *
	 * This is a static method, as tests for other entities might also need it, if
	 * they test an entity which requires the current entity.
	 *//*
		 * public static TrackRide createUpdatedEntity() { TrackRide trackRide = new
		 * TrackRide(); return trackRide; }
		 * 
		 * @BeforeEach public void initTest() { trackRideRepository.deleteAll();
		 * trackRide = createEntity(); }
		 * 
		 * @Test public void createTrackRide() throws Exception { int
		 * databaseSizeBeforeCreate = trackRideRepository.findAll().size();
		 * 
		 * // Create the TrackRide restTrackRideMockMvc.perform(post("/api/track-rides")
		 * .contentType(TestUtil.APPLICATION_JSON_UTF8)
		 * .content(TestUtil.convertObjectToJsonBytes(trackRide)))
		 * .andExpect(status().isCreated());
		 * 
		 * // Validate the TrackRide in the database List<TrackRide> trackRideList =
		 * trackRideRepository.findAll();
		 * assertThat(trackRideList).hasSize(databaseSizeBeforeCreate + 1); TrackRide
		 * testTrackRide = trackRideList.get(trackRideList.size() - 1); }
		 * 
		 * @Test public void createTrackRideWithExistingId() throws Exception { int
		 * databaseSizeBeforeCreate = trackRideRepository.findAll().size();
		 * 
		 * // Create the TrackRide with an existing ID trackRide.setId("existing_id");
		 * 
		 * // An entity with an existing ID cannot be created, so this API call must
		 * fail restTrackRideMockMvc.perform(post("/api/track-rides")
		 * .contentType(TestUtil.APPLICATION_JSON_UTF8)
		 * .content(TestUtil.convertObjectToJsonBytes(trackRide)))
		 * .andExpect(status().isBadRequest());
		 * 
		 * // Validate the TrackRide in the database List<TrackRide> trackRideList =
		 * trackRideRepository.findAll();
		 * assertThat(trackRideList).hasSize(databaseSizeBeforeCreate); }
		 * 
		 * 
		 * @Test public void getAllTrackRides() throws Exception { // Initialize the
		 * database trackRideRepository.save(trackRide);
		 * 
		 * // Get all the trackRideList
		 * restTrackRideMockMvc.perform(get("/api/track-rides?sort=id,desc"))
		 * .andExpect(status().isOk())
		 * .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		 * .andExpect(jsonPath("$.[*].id").value(hasItem(trackRide.getId()))); }
		 * 
		 * @Test public void getTrackRide() throws Exception { // Initialize the
		 * database trackRideRepository.save(trackRide);
		 * 
		 * // Get the trackRide
		 * restTrackRideMockMvc.perform(get("/api/track-rides/{id}", trackRide.getId()))
		 * .andExpect(status().isOk())
		 * .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		 * .andExpect(jsonPath("$.id").value(trackRide.getId())); }
		 * 
		 * @Test public void getNonExistingTrackRide() throws Exception { // Get the
		 * trackRide restTrackRideMockMvc.perform(get("/api/track-rides/{id}",
		 * Long.MAX_VALUE)) .andExpect(status().isNotFound()); }
		 * 
		 * @Test public void updateTrackRide() throws Exception { // Initialize the
		 * database trackRideService.save(trackRide);
		 * 
		 * int databaseSizeBeforeUpdate = trackRideRepository.findAll().size();
		 * 
		 * // Update the trackRide TrackRide updatedTrackRide =
		 * trackRideRepository.findById(trackRide.getId()).get();
		 * 
		 * restTrackRideMockMvc.perform(put("/api/track-rides")
		 * .contentType(TestUtil.APPLICATION_JSON_UTF8)
		 * .content(TestUtil.convertObjectToJsonBytes(updatedTrackRide)))
		 * .andExpect(status().isOk());
		 * 
		 * // Validate the TrackRide in the database List<TrackRide> trackRideList =
		 * trackRideRepository.findAll();
		 * assertThat(trackRideList).hasSize(databaseSizeBeforeUpdate); TrackRide
		 * testTrackRide = trackRideList.get(trackRideList.size() - 1); }
		 * 
		 * @Test public void updateNonExistingTrackRide() throws Exception { int
		 * databaseSizeBeforeUpdate = trackRideRepository.findAll().size();
		 * 
		 * // Create the TrackRide
		 * 
		 * // If the entity doesn't have an ID, it will throw BadRequestAlertException
		 * restTrackRideMockMvc.perform(put("/api/track-rides")
		 * .contentType(TestUtil.APPLICATION_JSON_UTF8)
		 * .content(TestUtil.convertObjectToJsonBytes(trackRide)))
		 * .andExpect(status().isBadRequest());
		 * 
		 * // Validate the TrackRide in the database List<TrackRide> trackRideList =
		 * trackRideRepository.findAll();
		 * assertThat(trackRideList).hasSize(databaseSizeBeforeUpdate); }
		 * 
		 * @Test public void deleteTrackRide() throws Exception { // Initialize the
		 * database trackRideService.save(trackRide);
		 * 
		 * int databaseSizeBeforeDelete = trackRideRepository.findAll().size();
		 * 
		 * // Delete the trackRide
		 * restTrackRideMockMvc.perform(delete("/api/track-rides/{id}",
		 * trackRide.getId()) .accept(TestUtil.APPLICATION_JSON_UTF8))
		 * .andExpect(status().isNoContent());
		 * 
		 * // Validate the database contains one less item List<TrackRide> trackRideList
		 * = trackRideRepository.findAll();
		 * assertThat(trackRideList).hasSize(databaseSizeBeforeDelete - 1); }
		 * 
		 * @Test public void equalsVerifier() throws Exception {
		 * TestUtil.equalsVerifier(TrackRide.class); TrackRide trackRide1 = new
		 * TrackRide(); trackRide1.setId("id1"); TrackRide trackRide2 = new TrackRide();
		 * trackRide2.setId(trackRide1.getId());
		 * assertThat(trackRide1).isEqualTo(trackRide2); trackRide2.setId("id2");
		 * assertThat(trackRide1).isNotEqualTo(trackRide2); trackRide1.setId(null);
		 * assertThat(trackRide1).isNotEqualTo(trackRide2); } }
		 */