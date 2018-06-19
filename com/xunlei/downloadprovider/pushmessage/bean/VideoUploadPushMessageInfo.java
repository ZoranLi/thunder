package com.xunlei.downloadprovider.pushmessage.bean;

import org.json.JSONObject;

public class VideoUploadPushMessageInfo extends BasePushMessageInfo {
    private String gcId = "";
    private String url = "";
    private String videoId = "";

    public static VideoUploadPushMessageInfo parse(PushOriginalInfo pushOriginalInfo) {
        BasePushMessageInfo videoUploadPushMessageInfo = new VideoUploadPushMessageInfo();
        JSONObject customMsgJO = pushOriginalInfo.getCustomMsgJO();
        BasePushMessageInfo.parseBaseInfo(videoUploadPushMessageInfo, pushOriginalInfo);
        videoUploadPushMessageInfo.setVideoId(customMsgJO.optString(PushResult.VIDEO_ID));
        videoUploadPushMessageInfo.setGcId(customMsgJO.optString(PushResult.GC_ID));
        videoUploadPushMessageInfo.setUrl(customMsgJO.optString("url"));
        return videoUploadPushMessageInfo;
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

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
