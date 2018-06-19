package com.xunlei.downloadprovider.pushmessage.bean;

public class AuctionPushMessageInfo extends BasePushMessageInfo {
    private String landingUrl = null;

    public static AuctionPushMessageInfo parse(PushOriginalInfo pushOriginalInfo) {
        BasePushMessageInfo auctionPushMessageInfo = new AuctionPushMessageInfo();
        BasePushMessageInfo.parseBaseInfo(auctionPushMessageInfo, pushOriginalInfo);
        auctionPushMessageInfo.setLandingUrl(pushOriginalInfo.getCustomMsgJO().optString("landing_url"));
        return auctionPushMessageInfo;
    }

    public String getLandingUrl() {
        return this.landingUrl;
    }

    public void setLandingUrl(String str) {
        this.landingUrl = str;
    }
}
