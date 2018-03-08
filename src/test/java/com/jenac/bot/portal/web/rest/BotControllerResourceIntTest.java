package com.jenac.bot.portal.web.rest;

import com.jenac.bot.portal.BotportalApp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the BotController REST controller.
 *
 * @see BotControllerResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BotportalApp.class)
public class BotControllerResourceIntTest {

    private MockMvc restMockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        BotControllerResource botControllerResource = new BotControllerResource();
        restMockMvc = MockMvcBuilders
            .standaloneSetup(botControllerResource)
            .build();
    }

    /**
    * Test state
    */
    @Test
    public void testState() throws Exception {
        restMockMvc.perform(get("/api/bot-controller/state"))
            .andExpect(status().is5xxServerError());
    }

}
