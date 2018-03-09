package com.jenac.bot.portal.web.rest.vm.bot;

/**
 * Created by lichen on 3/9/18.
 */
public class StateVM {
    private String loginUrl;
    private String state;


    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
