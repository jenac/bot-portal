package com.jenac.bot.portal.service;

import com.jenac.bot.portal.web.rest.vm.bot.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BotService {

    private final Logger log = LoggerFactory.getLogger(BotService.class);

    @Value("${botservice.host}")
    private String botServiceHost;



    public StateVM getState() {
        RestTemplate restTemplate = new RestTemplate();
        StateVM stateVM = restTemplate.getForObject(String.format("%s/bot/state", this.botServiceHost), StateVM.class);
        return stateVM;
    }

    public ResponseVM sendText(SendTextVM sendTextVM) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseVM responseVM = restTemplate.postForObject(String.format("%s/bot/text", this.botServiceHost), sendTextVM, ResponseVM.class);
        return responseVM;
    }

    public ResponseVM sendEmotion(SendEmotionVM sendEmotionVM) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseVM responseVM = restTemplate.postForObject(String.format("%s/bot/emotion", this.botServiceHost), sendEmotionVM, ResponseVM.class);
        return responseVM;
    }

    public ResponseVM sendPicture(SendPictureVM sendPictureVM) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseVM responseVM = restTemplate.postForObject(String.format("%s/bot/picture", this.botServiceHost), sendPictureVM, ResponseVM.class);
        return responseVM;
    }

    public ResponseVM sendFile(SendFileVM sendFileVM) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseVM responseVM = restTemplate.postForObject(String.format("%s/bot/file", this.botServiceHost), sendFileVM, ResponseVM.class);
        return responseVM;
    }

    public void setBotServiceHost(String botServiceHost) {
        this.botServiceHost = botServiceHost;
    }
//
//    public String getBotServiceHost() {
//        return this.botServiceHost;
//    }
}
