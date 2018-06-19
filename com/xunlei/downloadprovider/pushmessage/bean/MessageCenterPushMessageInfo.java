package com.xunlei.downloadprovider.pushmessage.bean;

import org.json.JSONObject;

public class MessageCenterPushMessageInfo extends BasePushMessageInfo {
    private String gcId = "";
    private String videoId = "";

    public static MessageCenterPushMessageInfo parse(PushOriginalInfo pushOriginalInfo) {
        BasePushMessageInfo messageCenterPushMessageInfo = new MessageCenterPushMessageInfo();
        JSONObject customMsgJO = pushOriginalInfo.getCustomMsgJO();
        BasePushMessageInfo.parseBaseInfo(messageCenterPushMessageInfo, pushOriginalInfo);
        messageCenterPushMessageInfo.setVideoId(customMsgJO.optString(PushResult.VIDEO_ID));
        messageCenterPushMessageInfo.setGcId(customMsgJO.optString(PushResult.GC_ID));
        return messageCenterPushMessageInfo;
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
