package com.jenac.bot.portal.web.rest.vm.bot;

/**
 * Created by lichen on 3/9/18.
 */
public class ResponseVM {
    private Boolean success;
    private String message;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
