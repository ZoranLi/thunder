package com.xunlei.downloadprovider.pushmessage.bean;

public class LivePushMessageInfo extends BasePushMessageInfo {
    private String roomInfo;

    public static LivePushMessageInfo parse(PushOriginalInfo pushOriginalInfo) {
        BasePushMessageInfo livePushMessageInfo = new LivePushMessageInfo();
        BasePushMessageInfo.parseBaseInfo(livePushMessageInfo, pushOriginalInfo);
        livePushMessageInfo.setRoomInfo(pushOriginalInfo.getCustomMsgJO().optString(PushResult.ROOM_INFO));
        return livePushMessageInfo;
    }

    public String getRoomInfo() {
        return this.roomInfo;
    }

    public void setRoomInfo(String str) {
        this.roomInfo = str;
    }
}
