package com.xunlei.downloadprovider.pushmessage.bean;

import org.json.JSONObject;

public class VideoPushMessageInfo extends BasePushMessageInfo {
    private String gcId = "";
    private String videoId = "";

    public static VideoPushMessageInfo parse(PushOriginalInfo pushOriginalInfo) {
        BasePushMessageInfo videoPushMessageInfo = new VideoPushMessageInfo();
        JSONObject customMsgJO = pushOriginalInfo.getCustomMsgJO();
        BasePushMessageInfo.parseBaseInfo(videoPushMessageInfo, pushOriginalInfo);
        videoPushMessageInfo.setVideoId(customMsgJO.optString(PushResult.VIDEO_ID));
        videoPushMessageInfo.setGcId(customMsgJO.optString(PushResult.GC_ID));
        return videoPushMessageInfo;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public void setVideoId(String str) {
        this.videoId = str;
    }

    public String getGcId() {
        return this.gcId;
    }

    public void setGcId(String str) {
        this.gcId = str;
    }
}
