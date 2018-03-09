package com.jenac.bot.portal.service;

import com.jenac.bot.portal.web.rest.vm.bot.StateVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BotService {

    private final Logger log = LoggerFactory.getLogger(BotService.class);

    public StateVM getState() {
        StateVM stateVM = new StateVM();
        stateVM.setLoginUrl("http://www.google.com");
        stateVM.setState("running");
        return stateVM;
    }
}
