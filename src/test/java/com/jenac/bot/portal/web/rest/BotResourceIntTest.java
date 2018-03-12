package com.jenac.bot.portal.web.rest;

import com.jenac.bot.portal.BotportalApp;
import com.jenac.bot.portal.service.BotService;
import com.jenac.bot.portal.web.rest.vm.bot.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * Test class for the Bot REST controller.
 *
 * @see BotResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BotportalApp.class)
public class BotResourceIntTest {

    private MockMvc restMockMvc;

    @Mock
    private BotService mockBotService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        BotResource botResource = new BotResource(mockBotService);
        restMockMvc = MockMvcBuilders
            .standaloneSetup(botResource)
            .build();
    }

    /**
     * Test state
     */
    @Test
    public void testState() throws Exception {
        StateVM stateVM = new StateVM();
        stateVM.setState("running");
        stateVM.setLoginUrl("http://www.google.com");
        when(mockBotService.getState()).thenReturn(stateVM);
        restMockMvc.perform(get("/api/bot/state"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.loginUrl").value("http://www.google.com"))
            .andExpect(jsonPath("$.state").value("running"));
    }

    @Test
    public void testSendText() throws Exception {
        SendTextVM sendTextVM = new SendTextVM();
        ResponseVM responseVM = new ResponseVM();
        responseVM.setMessage("");
        responseVM.setSuccess(true);
        when(mockBotService.sendText(sendTextVM)).thenReturn(responseVM);
        restMockMvc.perform(post("/api/bot/text")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sendTextVM)))
            .andExpect(status().isCreated());
//            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//            .andExpect(jsonPath("$.success").value(true))
//            .andExpect(jsonPath("$.message").value(""));
    }

    @Test
    public void testSendEmotion() throws Exception {
        SendEmotionVM sendEmotionVM = new SendEmotionVM();
        ResponseVM responseVM = new ResponseVM();
        responseVM.setMessage("");
        responseVM.setSuccess(true);
        when(mockBotService.sendEmotion(sendEmotionVM)).thenReturn(responseVM);
        restMockMvc.perform(post("/api/bot/emotion")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sendEmotionVM)))
            .andExpect(status().isCreated());
//            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//            .andExpect(jsonPath("$.success").value(true))
//            .andExpect(jsonPath("$.message").value(""));
    }

    @Test
    public void testSendPicture() throws Exception {
        SendPictureVM sendPictureVM = new SendPictureVM();
        ResponseVM responseVM = new ResponseVM();
        responseVM.setMessage("");
        responseVM.setSuccess(true);
        when(mockBotService.sendPicture(sendPictureVM)).thenReturn(responseVM);
        restMockMvc.perform(post("/api/bot/picture")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sendPictureVM)))
            .andExpect(status().isCreated());
//            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//            .andExpect(jsonPath("$.success").value(true))
//            .andExpect(jsonPath("$.message").value(""));
    }

    @Test
    public void testSendFile() throws Exception {
        SendFileVM sendFileVM = new SendFileVM();
        ResponseVM responseVM = new ResponseVM();
        responseVM.setMessage("");
        responseVM.setSuccess(true);
        when(mockBotService.sendFile(sendFileVM)).thenReturn(responseVM);
        restMockMvc.perform(post("/api/bot/file")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sendFileVM)))
            .andExpect(status().isCreated());
//            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//            .andExpect(jsonPath("$.success").value(true))
//            .andExpect(jsonPath("$.message").value(""));
    }
}


