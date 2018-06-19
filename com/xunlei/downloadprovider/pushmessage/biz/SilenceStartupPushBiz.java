package com.xunlei.downloadprovider.pushmessage.biz;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.pushmessage.bean.BasePushMessageInfo;
import com.xunlei.downloadprovider.pushmessage.bean.PushOriginalInfo;
import com.xunlei.downloadprovider.pushmessage.notification.IPushNotificationHandler;
import com.xunlei.downloadprovider.pushmessage.notification.NotificationManagerPushNotificationHandler;
import com.xunlei.downloadprovider.pushmessage.report.BasePushReporter;
import com.xunlei.downloadprovider.pushmessage.report.GeneralPushReporter;

public class SilenceStartupPushBiz extends BasePushBiz<BasePushMessageInfo> {
    public SilenceStartupPushBiz(PushOriginalInfo pushOriginalInfo) {
        super(pushOriginalInfo);
    }

    @NonNull
    public BasePushMessageInfo parsePushMessageInfo(PushOriginalInfo pushOriginalInfo) {
        return BasePushMessageInfo.parse(pushOriginalInfo);
    }

    public BasePushReporter<BasePushMessageInfo> createReporter() {
        return new GeneralPushReporter();
    }

    public IPushNotificationHandler<BasePushMessageInfo> createPushNotificationHandler() {
        return new NotificationManagerPushNotificationHandler<BasePushMessageInfo>() {
            public Intent createClickIntent(Context context, BasePushMessageInfo basePushMessageInfo) {
                return null;
            }

            public Notification getNotification(Context context, BasePushMessageInfo basePushMessageInfo, int i, Bitmap bitmap) {
                return null;
            }

            public int getNotificationId(BasePushMessageInfo basePushMessageInfo) {
                return 0;
            }

            public String getNotificationTag(BasePushMessageInfo basePushMessageInfo) {
                return null;
            }

            public void onClick(Context context, BasePushMessageInfo basePushMessageInfo) {
            }

            public void onDismiss(Context context, BasePushMessageInfo basePushMessageInfo) {
            }

            public BasePushBiz$a shouldInterceptNotification(Context context, BasePushMessageInfo basePushMessageInfo) {
                return BasePushBiz$a.a(true, "don't need show.");
            }
        };
    }
}
