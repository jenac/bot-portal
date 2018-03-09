package com.jenac.bot.portal.web.rest.vm.bot;

/**
 * Created by lichen on 3/9/18.
 */
public class SendPictureVM {
    private String to;
    private String url;
    private String filename;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
