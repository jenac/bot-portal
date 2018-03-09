package com.jenac.bot.portal.web.rest.vm.bot;

/**
 * Created by lichen on 3/9/18.
 */
public class SendFileVM {
    private String to;
    private String path;
    private String filename;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
