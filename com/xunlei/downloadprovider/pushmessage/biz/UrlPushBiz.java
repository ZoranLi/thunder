package com.xunlei.downloadprovider.pushmessage.biz;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.alibaba.wireless.security.SecExceptionCode;
import com.umeng.message.entity.UMessage;
import com.xunlei.downloadprovider.launch.LaunchActivity;
import com.xunlei.downloadprovider.pushmessage.bean.BasePushMessageInfo;
import com.xunlei.downloadprovider.pushmessage.bean.PushOriginalInfo;
import com.xunlei.downloadprovider.pushmessage.bean.UrlPushMessageInfo;
import com.xunlei.downloadprovider.pushmessage.m;
import com.xunlei.downloadprovider.pushmessage.notification.IPushNotificationHandler;
import com.xunlei.downloadprovider.pushmessage.notification.NotificationManagerPushNotificationHandler;
import com.xunlei.downloadprovider.pushmessage.p;
import com.xunlei.downloadprovider.pushmessage.report.BasePushReporter;
import com.xunlei.downloadprovider.pushmessage.report.GeneralPushReporter;
import com.xunlei.xllib.android.XLIntent;

public class UrlPushBiz extends BasePushBiz<UrlPushMessageInfo> {
    public UrlPushBiz(PushOriginalInfo pushOriginalInfo) {
        super(pushOriginalInfo);
    }

    @NonNull
    public UrlPushMessageInfo parsePushMessageInfo(PushOriginalInfo pushOriginalInfo) {
        return UrlPushMessageInfo.parse(pushOriginalInfo);
    }

    public BasePushReporter<UrlPushMessageInfo> createReporter() {
        return new GeneralPushReporter();
    }

    public IPushNotificationHandler<UrlPushMessageInfo> createPushNotificationHandler() {
        return new NotificationManagerPushNotificationHandler<UrlPushMessageInfo>() {
            public int getNotificationId(UrlPushMessageInfo urlPushMessageInfo) {
                return 1000;
            }

            public String getNotificationTag(UrlPushMessageInfo urlPushMessageInfo) {
                return null;
            }

            public void onClick(Context context, UrlPushMessageInfo urlPushMessageInfo) {
            }

            public void onDismiss(Context context, UrlPushMessageInfo urlPushMessageInfo) {
            }

            public Notification getNotification(Context context, UrlPushMessageInfo urlPushMessageInfo, int i, Bitmap bitmap) {
                if (p.a) {
                    i = 0;
                }
                return m.a(context, (BasePushMessageInfo) urlPushMessageInfo, i, bitmap);
            }

            public Intent createClickIntent(Context context, UrlPushMessageInfo urlPushMessageInfo) {
                Intent xLIntent = new XLIntent(context, LaunchActivity.class);
                xLIntent.addFlags(268435456);
                xLIntent.putExtra("from", UMessage.DISPLAY_TYPE_NOTIFICATION);
                xLIntent.putExtra("url", urlPushMessageInfo.getUrl());
                xLIntent.putExtra("title", urlPushMessageInfo.getTitle());
                xLIntent.putExtra("dispatch_from_key", SecExceptionCode.SEC_ERROE_OPENSDK_INVALID_LENGTH);
                return xLIntent;
            }

            public BasePushBiz$a shouldInterceptNotification(Context context, UrlPushMessageInfo urlPushMessageInfo) {
                return BasePushBiz$a.a(null, "");
            }
        };
    }
}
