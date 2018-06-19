package com.xunlei.downloadprovider.pushmessage.bean;

public class UrlPushMessageInfo extends BasePushMessageInfo {
    private String url = "";

    public static UrlPushMessageInfo parse(PushOriginalInfo pushOriginalInfo) {
        BasePushMessageInfo urlPushMessageInfo = new UrlPushMessageInfo();
        BasePushMessageInfo.parseBaseInfo(urlPushMessageInfo, pushOriginalInfo);
        urlPushMessageInfo.setUrl(pushOriginalInfo.getCustomMsgJO().optString("url"));
        return urlPushMessageInfo;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
