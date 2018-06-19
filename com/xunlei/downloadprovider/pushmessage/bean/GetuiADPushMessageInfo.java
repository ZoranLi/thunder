package com.xunlei.downloadprovider.pushmessage.bean;

import android.content.Intent;
import com.xunlei.downloadprovider.ad.notification.getui.info.GetuiNotificationADInfo;

public class GetuiADPushMessageInfo extends BasePushMessageInfo {
    private GetuiNotificationADInfo mGetuiNotificationADInfo = null;

    public static GetuiADPushMessageInfo parse(Intent intent) {
        GetuiADPushMessageInfo getuiADPushMessageInfo = new GetuiADPushMessageInfo();
        getuiADPushMessageInfo.setGetuiNotificationADInfo(GetuiNotificationADInfo.parse(intent));
        intent = new StringBuilder("GETUI_NOTIFICATION_AD_");
        intent.append(getuiADPushMessageInfo.getGetuiNotificationADInfo().getMessageId());
        getuiADPushMessageInfo.setMessageId(intent.toString());
        getuiADPushMessageInfo.setResTypeReport("getui_notification_ad");
        getuiADPushMessageInfo.setDisplayType(1001);
        getuiADPushMessageInfo.setBigPic(getuiADPushMessageInfo.getGetuiNotificationADInfo().getValidImage());
        getuiADPushMessageInfo.setServerType(4);
        getuiADPushMessageInfo.setOriginMsgBody("getui ad");
        getuiADPushMessageInfo.setCustomMsgBody("");
        return getuiADPushMessageInfo;
    }

    public GetuiNotificationADInfo getGetuiNotificationADInfo() {
        return this.mGetuiNotificationADInfo;
    }

    public void setGetuiNotificationADInfo(GetuiNotificationADInfo getuiNotificationADInfo) {
        this.mGetuiNotificationADInfo = getuiNotificationADInfo;
    }
}
