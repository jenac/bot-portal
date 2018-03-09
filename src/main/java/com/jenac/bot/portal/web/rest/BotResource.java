package com.jenac.bot.portal.web.rest;

import com.jenac.bot.portal.service.BotService;
import com.jenac.bot.portal.web.rest.vm.bot.StateVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
