package com.xunlei.downloadprovider.pushmessage.biz;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.ad.notification.NotificationADInfo;
import com.xunlei.downloadprovider.ad.notification.a;
import com.xunlei.downloadprovider.notification.g;
import com.xunlei.downloadprovider.pushmessage.bean.GetuiADPushMessageInfo;
import com.xunlei.downloadprovider.pushmessage.bean.PushOriginalInfo;
import com.xunlei.downloadprovider.pushmessage.notification.IPushNotificationHandler;
import com.xunlei.downloadprovider.pushmessage.notification.NotificationServicePushNotificationHandler;
import com.xunlei.downloadprovider.pushmessage.report.BasePushReporter;
import com.xunlei.downloadprovider.pushmessage.report.EmptyPushReporter;

public class GetuiADPushBiz extends BasePushBiz<GetuiADPushMessageInfo> {
    @NonNull
    public GetuiADPushMessageInfo parsePushMessageInfo(PushOriginalInfo pushOriginalInfo) {
        return null;
    }

    public GetuiADPushBiz(PushOriginalInfo pushOriginalInfo) {
        super(pushOriginalInfo);
    }

    public GetuiADPushBiz(Intent intent) {
        super(null);
        this.mInfo = parsePushMessageInfo(intent);
    }

    @NonNull
    public GetuiADPushMessageInfo parsePushMessageInfo(Intent intent) {
        return GetuiADPushMessageInfo.parse(intent);
    }

    public BasePushReporter<GetuiADPushMessageInfo> createReporter() {
        return new EmptyPushReporter<GetuiADPushMessageInfo>() {
            public void reportReceive(Context context, GetuiADPushMessageInfo getuiADPushMessageInfo) {
                if (getuiADPushMessageInfo.getGetuiNotificationADInfo() != null) {
                    getuiADPushMessageInfo.getGetuiNotificationADInfo().report(context, NotificationADInfo.REPORT_STATUS_RECEIVE, null);
                }
            }

            public void reportShow(Context context, GetuiADPushMessageInfo getuiADPushMessageInfo) {
                if (getuiADPushMessageInfo.getGetuiNotificationADInfo() != null) {
                    getuiADPushMessageInfo.getGetuiNotificationADInfo().report(context, NotificationADInfo.REPORT_STATUS_SHOW, null);
                }
            }

            public void reportClick(Context context, GetuiADPushMessageInfo getuiADPushMessageInfo) {
                if (getuiADPushMessageInfo.getGetuiNotificationADInfo() != null) {
                    getuiADPushMessageInfo.getGetuiNotificationADInfo().report(context, NotificationADInfo.REPORT_STATUS_CLICK, null);
                }
            }

            public void reportError(Context context, GetuiADPushMessageInfo getuiADPushMessageInfo, String str) {
                if (getuiADPushMessageInfo.getGetuiNotificationADInfo() != null) {
                    getuiADPushMessageInfo.getGetuiNotificationADInfo().report(context, "error", str);
                }
            }
        };
    }

    public IPushNotificationHandler<GetuiADPushMessageInfo> createPushNotificationHandler() {
        return new NotificationServicePushNotificationHandler<GetuiADPushMessageInfo>() {
            public String getNotificationTag(GetuiADPushMessageInfo getuiADPushMessageInfo) {
                return "notification_ad";
            }

            public BasePushBiz$a shouldInterceptNotification(Context context, GetuiADPushMessageInfo getuiADPushMessageInfo) {
                if (!a.b()) {
                    return BasePushBiz$a.a(true, "switch off");
                }
                if (getuiADPushMessageInfo.getGetuiNotificationADInfo() == null) {
                    return BasePushBiz$a.a(true, "getuiNotificationADInfo is null");
                }
                if (getuiADPushMessageInfo.getGetuiNotificationADInfo().isLandingResolve(context) == null) {
                    return BasePushBiz$a.a(true, "url can not be resolve.");
                }
                return BasePushBiz$a.a(null, "");
            }

            public Notification getNotification(Context context, GetuiADPushMessageInfo getuiADPushMessageInfo, int i, Bitmap bitmap) {
                return getuiADPushMessageInfo.getGetuiNotificationADInfo().buildNotification(context, i, bitmap);
            }

            public int getNotificationId(GetuiADPushMessageInfo getuiADPushMessageInfo) {
                return g.a();
            }

            public Intent createClickIntent(Context context, GetuiADPushMessageInfo getuiADPushMessageInfo) {
                context = getuiADPushMessageInfo.getGetuiNotificationADInfo().buildClickIntent(context);
                context.addFlags(268435456);
                return context;
            }
        };
    }
}
