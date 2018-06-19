package com.xunlei.downloadprovider.pushmessage.biz;

import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.pushmessage.bean.PushOriginalInfo;
import com.xunlei.downloadprovider.pushmessage.bean.VideoPushMessageInfo;
import com.xunlei.downloadprovider.pushmessage.notification.IPushNotificationHandler;
import com.xunlei.downloadprovider.pushmessage.notification.VideoPushNotificationHandler;
import com.xunlei.downloadprovider.pushmessage.report.BasePushReporter;
import com.xunlei.downloadprovider.pushmessage.report.GeneralPushReporter;

public class VideoPushBiz extends BasePushBiz<VideoPushMessageInfo> {
    public VideoPushBiz(PushOriginalInfo pushOriginalInfo) {
        super(pushOriginalInfo);
    }

    @NonNull
    public VideoPushMessageInfo parsePushMessageInfo(PushOriginalInfo pushOriginalInfo) {
        return VideoPushMessageInfo.parse(pushOriginalInfo);
    }

    public BasePushReporter<VideoPushMessageInfo> createReporter() {
        return new GeneralPushReporter();
    }

    public IPushNotificationHandler<VideoPushMessageInfo> createPushNotificationHandler() {
        return new VideoPushNotificationHandler();
    }
}
