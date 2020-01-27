package com.mycipl.web.rest;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mycipl.MyciplApp;

/**
 * Test class for the UserJWTController REST controller.
 *
 * @see UserJWTController
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyciplApp.class)
public class UserJWTControllerIntTest {/*

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        UserJWTController userJWTController = new UserJWTController(tokenProvider, authenticationManager);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userJWTController)
            .setControllerAdvice(exceptionTranslator)
            .build();
    }

    @Test
    public void testAuthorize() throws Exception {
        User user = new User();
        user.setDseLoginId("user-jwt-controller");
        user.setEmail("user-jwt-controller@example.com");
        user.setActivated(true);
        user.setPassword(passwordEncoder.encode("test"));

        userRepository.save(user);

        LoginVM login = new LoginVM();
        login.setDseLoginId("user-jwt-controller");
        login.setPassword("test");
        mockMvc.perform(post("/api/authenticate")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(login)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id_token").isString())
            .andExpect(jsonPath("$.id_token").isNotEmpty())
            .andExpect(header().string("Authorization", not(nullValue())))
            .andExpect(header().string("Authorization", not(isEmptyString())));
    }

    @Test
    public void testAuthorizeWithRememberMe() throws Exception {
        User user = new User();
        user.setDseLoginId("user-jwt-controller-remember-me");
        user.setEmail("user-jwt-controller-remember-me@example.com");
        user.setActivated(true);
        user.setPassword(passwordEncoder.encode("test"));

        userRepository.save(user);

        LoginVM login = new LoginVM();
        login.setDseLoginId("user-jwt-controller-remember-me");
        login.setPassword("test");
        login.setRememberMe(true);
        mockMvc.perform(post("/api/authenticate")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(login)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id_token").isString())
            .andExpect(jsonPath("$.id_token").isNotEmpty())
            .andExpect(header().string("Authorization", not(nullValue())))
            .andExpect(header().string("Authorization", not(isEmptyString())));
    }

    @Test
    public void testAuthorizeFails() throws Exception {
        LoginVM login = new LoginVM();
        login.setDseLoginId("wrong-user");
        login.setPassword("wrong password");
        mockMvc.perform(post("/api/authenticate")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(login)))
            .andExpect(status().isUnauthorized())
            .andExpect(jsonPath("$.id_token").doesNotExist())
            .andExpect(header().doesNotExist("Authorization"));
    }
*/}
