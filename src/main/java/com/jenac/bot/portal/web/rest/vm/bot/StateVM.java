package com.jenac.bot.portal.web.rest.vm.bot;

import java.util.List;

/**
 * Created by lichen on 3/9/18.
 */
public class StateVM {
    private String loginUrl;
    private String state;
    private String avatar;
    private List<ContactVM> contacts;

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<ContactVM> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactVM> contacts) {
        this.contacts = contacts;
    }
}
