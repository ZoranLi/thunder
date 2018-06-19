package com.xunlei.downloadprovider.pushmessage.biz;

import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.pushmessage.bean.BasePushMessageInfo;
import com.xunlei.downloadprovider.pushmessage.bean.PushOriginalInfo;
import com.xunlei.downloadprovider.pushmessage.bean.WebsiteCollectUpdatePushMessageInfo;
import com.xunlei.downloadprovider.pushmessage.notification.IPushNotificationHandler;
import com.xunlei.downloadprovider.pushmessage.notification.WebsiteCollectUpdateNotificationHandler;
import com.xunlei.downloadprovider.pushmessage.report.BasePushReporter;
import com.xunlei.downloadprovider.pushmessage.report.GeneralPushReporter;

public class WebsiteCollectUpdatePushBiz extends BasePushBiz {
    public WebsiteCollectUpdatePushBiz(PushOriginalInfo pushOriginalInfo) {
        super(pushOriginalInfo);
    }

    @NonNull
    public BasePushMessageInfo parsePushMessageInfo(PushOriginalInfo pushOriginalInfo) {
        return WebsiteCollectUpdatePushMessageInfo.parse(pushOriginalInfo);
    }

    public BasePushReporter createReporter() {
        return new GeneralPushReporter();
    }

    public IPushNotificationHandler createPushNotificationHandler() {
        return new WebsiteCollectUpdateNotificationHandler();
    }
}
