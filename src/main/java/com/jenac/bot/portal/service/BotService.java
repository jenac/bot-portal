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

    @Value("${application.botservice.host}")
    private String botServiceHost;



    public StateVM getState() {
        RestTemplate restTemplate = new RestTemplate();
        StateVM stateVM = restTemplate.getForObject(String.format("%s/bot/state", this.botServiceHost), StateVM.class);
        return stateVM;
    }

    public ResponseVM sendText(SendTextVM sendTextVM) {
        ResponseVM responseVM = new ResponseVM();
        responseVM.setSuccess(true);
        responseVM.setMessage("");
        return responseVM;
    }

    public ResponseVM sendEmotion(SendEmotionVM sendEmotionVM) {
        ResponseVM responseVM = new ResponseVM();
        responseVM.setSuccess(true);
        responseVM.setMessage("");
        return responseVM;
    }

    public ResponseVM sendPicture(SendPictureVM sendPictureVM) {
        ResponseVM responseVM = new ResponseVM();
        responseVM.setSuccess(true);
        responseVM.setMessage("");
        return responseVM;
    }

    public ResponseVM sendFile(SendFileVM sendFileVM) {
        ResponseVM responseVM = new ResponseVM();
        responseVM.setSuccess(true);
        responseVM.setMessage("");
        return responseVM;
    }

    public void setBotServiceHost(String botServiceHost) {
        this.botServiceHost = botServiceHost;
    }
}
