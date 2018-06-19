package com.xunlei.downloadprovider.pushmessage.biz;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.launch.LaunchActivity;
import com.xunlei.downloadprovider.personal.message.d;
import com.xunlei.downloadprovider.pushmessage.bean.BasePushMessageInfo;
import com.xunlei.downloadprovider.pushmessage.bean.PushOriginalInfo;
import com.xunlei.downloadprovider.pushmessage.m;
import com.xunlei.downloadprovider.pushmessage.notification.IPushNotificationHandler;
import com.xunlei.downloadprovider.pushmessage.notification.NotificationManagerPushNotificationHandler;
import com.xunlei.downloadprovider.pushmessage.report.BasePushReporter;
import com.xunlei.downloadprovider.pushmessage.report.GeneralPushReporter;
import com.xunlei.xllib.android.XLIntent;

public class VideoSharePushBiz extends BasePushBiz<BasePushMessageInfo> {
    public VideoSharePushBiz(PushOriginalInfo pushOriginalInfo) {
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
            public int getNotificationId(BasePushMessageInfo basePushMessageInfo) {
                return 1022;
            }

            public String getNotificationTag(BasePushMessageInfo basePushMessageInfo) {
                return null;
            }

            public void onClick(Context context, BasePushMessageInfo basePushMessageInfo) {
            }

            public void onDismiss(Context context, BasePushMessageInfo basePushMessageInfo) {
            }

            public Notification getNotification(Context context, BasePushMessageInfo basePushMessageInfo, int i, Bitmap bitmap) {
                context = m.a(context, basePushMessageInfo.getTitle(), basePushMessageInfo.getDesc(), i);
                d.a().b();
                return context;
            }

            public Intent createClickIntent(Context context, BasePushMessageInfo basePushMessageInfo) {
                Intent xLIntent = new XLIntent(context, LaunchActivity.class);
                xLIntent.addFlags(268435456);
                xLIntent.putExtra("resType", basePushMessageInfo.getResTypeReport());
                xLIntent.putExtra("dispatch_from_key", 1116);
                return xLIntent;
            }

            public BasePushBiz$a shouldInterceptNotification(Context context, BasePushMessageInfo basePushMessageInfo) {
                return BasePushBiz$a.a(null, "");
            }
        };
    }
}
