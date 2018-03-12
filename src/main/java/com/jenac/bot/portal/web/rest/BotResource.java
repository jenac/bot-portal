package com.jenac.bot.portal.web.rest;

import com.jenac.bot.portal.service.BotService;
import com.jenac.bot.portal.web.rest.vm.bot.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Bot controller
 */
@RestController
@RequestMapping("/api/bot")
public class BotResource {
    private final Logger log = LoggerFactory.getLogger(BotResource.class);

    private final BotService botService;


    public  BotResource(BotService botService) {
        this.botService = botService;
    }

    /**
    * GET state
    */
    @GetMapping("/state")
    public StateVM state() {

        return this.botService.getState();
    }


    @PostMapping("/text")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseVM sendText(@Valid @RequestBody SendTextVM sendTextVM) {
        return this.botService.sendText(sendTextVM);
    }

    @PostMapping("/emotion")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseVM sendEmotion(@Valid @RequestBody SendEmotionVM sendEmotionVM) {
        return this.botService.sendEmotion(sendEmotionVM);
    }

    @PostMapping("/picture")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseVM sendPicture(@Valid @RequestBody SendPictureVM sendPictureVM) {
        return this.botService.sendPicture(sendPictureVM);
    }

    @PostMapping("/file")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseVM sendFile(@Valid @RequestBody SendFileVM sendFileVM) {
        return this.botService.sendFile(sendFileVM);
    }

}
