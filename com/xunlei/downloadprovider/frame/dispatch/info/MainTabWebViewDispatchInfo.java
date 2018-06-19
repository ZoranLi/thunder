package com.xunlei.downloadprovider.frame.dispatch.info;

public class MainTabWebViewDispatchInfo extends MainTabDispatchInfo {
    private String title = "";
    private String url = "";

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
