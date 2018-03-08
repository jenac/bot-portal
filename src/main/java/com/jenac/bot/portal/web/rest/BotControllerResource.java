package com.jenac.bot.portal.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BotController controller
 */
@RestController
@RequestMapping("/api/bot-controller")
public class BotControllerResource {

    private final Logger log = LoggerFactory.getLogger(BotControllerResource.class);

    /**
    * GET state
    */
    @GetMapping("/state")
    public String state() {
        return "state";
    }

}
