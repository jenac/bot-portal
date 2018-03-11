package com.jenac.bot.portal.service;

import com.jenac.bot.portal.web.rest.vm.bot.ContactVM;
import com.jenac.bot.portal.web.rest.vm.bot.ResponseVM;
import com.jenac.bot.portal.web.rest.vm.bot.SendTextVM;
import com.jenac.bot.portal.web.rest.vm.bot.StateVM;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

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
    public void testAllApi() {
        //get state
        StateVM stateVM = botService.getState();
        assert (stateVM != null);
        //find the test user
        ContactVM found = stateVM.getContacts().stream().filter(c-> c.getRemark() == "test").findFirst().get();
        assert (found != null);
        //send text
        SendTextVM sendTextVM = new SendTextVM();
        sendTextVM.setTo(found.getUsername());
        sendTextVM.setText("Hello, I am sending this message from spring unit test!");
        ResponseVM responseVm = botService.sendText(sendTextVM);
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
