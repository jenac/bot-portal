package com.jenac.bot.portal.web.rest;

import com.jenac.bot.portal.BotportalApp;
import com.jenac.bot.portal.service.BotService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the Bot REST controller.
 *
 * @see BotResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BotportalApp.class)
public class BotResourceIntTest {

    private MockMvc restMockMvc;

    @Autowired
    private BotService botService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        BotResource botResource = new BotResource(botService);
        restMockMvc = MockMvcBuilders
            .standaloneSetup(botResource)
            .build();
    }

    /**
    * Test state
    */
    @Test
    public void testState() throws Exception {
        restMockMvc.perform(get("/api/bot/state"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.loginUrl").value("http://www.google.com"))
            .andExpect(jsonPath("$.state").value("running"));
    }

}
