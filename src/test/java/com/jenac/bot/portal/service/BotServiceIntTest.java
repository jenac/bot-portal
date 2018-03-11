package com.jenac.bot.portal.service;

import com.jenac.bot.portal.web.rest.vm.bot.StateVM;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

public class BotServiceIntTest {
    static final String botServiceHost = "http://localhost:8888/";
    BotService botService;
    @Before
    public void setup() {
        botService = new BotService();
        botService.setBotServiceHost(botServiceHost);
    }

    @Test
    public void getState() {
        StateVM stateVM = botService.getState();
        assert (stateVM != null);
    }

    @Test
    public void sendText() {
    }

    @Test
    public void sendEmotion() {
    }

    @Test
    public void sendPicture() {
    }

    @Test
    public void sendFile() {
    }
}
