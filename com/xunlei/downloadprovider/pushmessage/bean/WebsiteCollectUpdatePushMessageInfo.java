package com.xunlei.downloadprovider.pushmessage.bean;

public class WebsiteCollectUpdatePushMessageInfo extends BasePushMessageInfo {
    private String collectUpdateMainPageUrl;

    public static WebsiteCollectUpdatePushMessageInfo parse(PushOriginalInfo pushOriginalInfo) {
        BasePushMessageInfo websiteCollectUpdatePushMessageInfo = new WebsiteCollectUpdatePushMessageInfo();
        BasePushMessageInfo.parseBaseInfo(websiteCollectUpdatePushMessageInfo, pushOriginalInfo);
        websiteCollectUpdatePushMessageInfo.setCollectUpdateMainPageUrl(pushOriginalInfo.getCustomMsgJO().optString(PushResult.COLLECT_UPDATE_MAIN_URL));
        return websiteCollectUpdatePushMessageInfo;
    }

    public String getCollectUpdateMainPageUrl() {
        return this.collectUpdateMainPageUrl;
    }

    public void setCollectUpdateMainPageUrl(String str) {
        this.collectUpdateMainPageUrl = str;
    }
}
